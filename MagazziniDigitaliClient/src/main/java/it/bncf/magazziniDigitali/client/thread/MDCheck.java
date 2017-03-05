/**
 * 
 */
package it.bncf.magazziniDigitali.client.thread;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.depositolegale.www.software.Software;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;
import mx.randalf.digest.MD5;

import org.apache.log4j.Logger;

/**
 * @author massi
 * 
 */
public abstract class MDCheck extends Thread {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = Logger.getLogger(MDCheck.class);

	protected String fileExt = ".txt";

	private boolean testMode;
	private IMDConfiguration<Software> configuration = null;

	/**
	 * @param arg0
	 * @param arg1
	 */
	public MDCheck(Runnable target, String name, boolean testMode, IMDConfiguration<Software> configuration) {
		super(target, name);
		this.testMode = testMode;
		this.configuration = configuration;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Vector<String> pathInput = null;
		Vector<String> pathDescriptati = null;
		boolean sender = false;

		try {

			pathInput = (Vector<String>) Configuration.getValues("pathExcel");
			pathDescriptati = (Vector<String>) Configuration.getValues("pathDescriptati");
			while (true) {
				for (int x = 0; x < pathInput.size(); x++) {
					log.info(getName() + " Analizzo la cartella [" + pathInput.get(x) + "]");
					sender = checkExcel(new File(pathInput.get(x)), new File(pathDescriptati.get(x)), testMode,
							configuration);
					if (testMode && sender) {
						break;
					}
				}
				if (testMode) {
					break;
				}
			}
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * Metodo utilizzato per testare il contenuto di una cartella
	 * 
	 * @param pathInput
	 */
	private boolean checkExcel(File pathExcel, File pathDescriptati, boolean testMode,
			IMDConfiguration<Software> configuration) {
		File[] fl = null;
		File f = null;
		File fElab = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		FileWriter fw = null;
		String line = null;
		String[] st = null;
		File fileTarGz = null;
		boolean completato = false;
		MD5 md5 = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:SS");
		boolean testComp = false;
		boolean sender = false;

		if (pathExcel.exists()) {
			fl = pathExcel.listFiles(new FileFilter() {

				@Override
				public boolean accept(File f) {
					boolean ris = false;
					File fElab = null;

					// Verifico che il file/cartella non sia di tipo nascosto
					if (!f.getName().startsWith(".") && !f.isHidden()) {
						// controllo se è una cartella
						if (f.getName().toLowerCase().endsWith(fileExt)) {
							fElab = new File(f.getAbsolutePath() + ".elab");
							if (!fElab.exists()) {
								ris = true;
							}
						}
					}
					return ris;
				}
			});
			Arrays.sort(fl);
			if (fl.length == 0) {
				waiting(600,600);
			} else {
				for (int x = 0; x < fl.length; x++) {
					f = fl[x];

					fElab = new File(f.getAbsolutePath() + ".elab");
					if (!fElab.exists()) {
						log.info(getName() + " Elaboro il file [" + f.getAbsolutePath() + "]");
						try {
							md5 = new MD5();
							fr = new FileReader(f);
							br = new BufferedReader(fr);
							completato = true;
							while ((line = br.readLine()) != null) {
								st = line.split("\t");
								fileTarGz = genFileTarGz(pathDescriptati, st[0]);
								if (fileTarGz.exists()) {
									try {
										log.info(getName() + " Elaboro il file [" + fileTarGz.getAbsolutePath() + "]");
										if (!analize(fileTarGz, configuration)) {
											completato = false;
										}
										sender = true;
										if (testMode && isSender()) {
											testComp = true;
											break;
										}
									} catch (NoSuchAlgorithmException e) {
										log.error(getName() + " " + e.getMessage(), e);
										completato = false;
									} catch (FileNotFoundException e) {
										log.error(getName() + " " + e.getMessage(), e);
										completato = false;
									} catch (IOException e) {
										log.error(getName() + " " + e.getMessage(), e);
										completato = false;
									} catch (ClientMDException e) {
										log.error(getName() + " " + e.getMessage(), e);
										completato = false;
									} catch (Exception e) {
										log.error(getName() + " " + e.getMessage(), e);
										completato = false;
									}
								}
							}
							if (completato) {
								try {
									fw = new FileWriter(fElab);
									bw = new BufferedWriter(fw);
									bw.write(md5.getDigest(f) + "\t"
											+ df.format(new Date(new GregorianCalendar().getTimeInMillis())));
								} catch (Exception e) {
									log.error(getName() + " " + e.getMessage(), e);
								} finally {
									try {
										if (bw != null) {
											bw.flush();
											bw.close();
										}
										if (fw != null) {
											fw.close();
										}
									} catch (Exception e) {
										log.error(getName() + " " + e.getMessage(), e);
									}
								}

							}
							waiting(300, 300);
							if (testMode && testComp) {
								break;
							}
						} catch (FileNotFoundException e) {
							log.error(getName() + " " + e.getMessage(), e);
						} catch (IOException e) {
							log.error(getName() + " " + e.getMessage(), e);
						} catch (NoSuchAlgorithmException e) {
							log.error(getName() + " " + e.getMessage(), e);
						} catch (Exception e) {
							log.error(getName() + " " + e.getMessage(), e);
						} finally {
							try {
								if (br != null) {
									br.close();
								}
								if (fr != null) {
									fr.close();
								}
							} catch (IOException e) {
								log.error(getName() + " " + e.getMessage(), e);
							}
						}
					} else {
						log.info(getName() + " Il file [" + f.getAbsolutePath() + "] risulta completamente elaborato");
						waiting(15, 10);
					}
				}
			}
		} else {
			log.error(getName() + " La cartella [" + pathExcel.getAbsolutePath() + "] non esiste");
		}
		return sender;
	}

	private void waiting(int rSync, int complete) {
		if (getName().equals("RSync")) {
			try {
				System.gc();
				Thread.sleep(rSync * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (getName().equals("Complete")) {
			try {
				System.gc();
				Thread.sleep(complete * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	protected abstract File genFileTarGz(File pathDescriptati, String fileName);

	protected abstract boolean analize(File fileTarGz, IMDConfiguration<Software> configuration)
			throws NoSuchAlgorithmException, FileNotFoundException, IOException, ClientMDException;

	protected abstract boolean isSender();
}
