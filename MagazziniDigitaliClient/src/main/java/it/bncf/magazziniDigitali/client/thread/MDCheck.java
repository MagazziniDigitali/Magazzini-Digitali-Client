/**
 * 
 */
package it.bncf.magazziniDigitali.client.thread;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.bncf.magazziniDigitali.configuration.exception.MDConfigurationException;
import it.depositolegale.www.software.Software;
import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;
import mx.randalf.digest.MD5;

/**
 * @author massi
 * 
 */
public abstract class MDCheck extends Thread {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = LogManager.getLogger(MDCheck.class);

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
		File pathElab = null;

		try {

			pathInput = (Vector<String>) Configuration.getValues("pathExcel");
			pathDescriptati = (Vector<String>) Configuration.getValues("pathDescriptati");
			while (true) {
				for (int x = 0; x < pathInput.size(); x++) {
					log.info("\n" + getName() + " Analizzo la cartella [" + pathInput.get(x) + "]");
					pathElab = new File(pathInput.get(x));
					sender = checkExcel(pathElab, new File(pathDescriptati.get(x)), testMode, configuration);
					postElab(pathElab);
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

	protected abstract void postElab(File pathElab);

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
					if (!f.getName().startsWith(".") && !f.isHidden() && f.isFile()) {
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
				waiting(600, 600);
			} else {
				for (int x = 0; x < fl.length; x++) {
					f = fl[x];

					fElab = new File(f.getAbsolutePath() + ".elab");
					if (!fElab.exists()) {
						log.info("\n" + getName() + " Elaboro il file [" + f.getAbsolutePath() + "]");
						try {
							fr = new FileReader(f);
							br = new BufferedReader(fr);
							completato = true;
							while ((line = br.readLine()) != null) {
								st = line.split("\t");

								try {
									fileTarGz = genFileTarGz(pathDescriptati, st[0], configuration);
									if (fileTarGz != null && fileTarGz.exists()) {
										try {
											log.info("\n" + getName() + " Elaboro il file ["
													+ fileTarGz.getAbsolutePath() + "]");
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
								} catch (MDCheckException e1) {
									log.error(e1.getMessage(), e1);
								}
							}
							if (completato) {
								try {
									fw = new FileWriter(fElab);
									bw = new BufferedWriter(fw);
									md5 = new MD5(f);
									bw.write(md5.getDigest() + "\t"
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
							waiting(30, 30);
							if (testMode && testComp) {
								break;
							}
						} catch (FileNotFoundException e) {
							log.error(getName() + " " + e.getMessage(), e);
						} catch (IOException e) {
							log.error(getName() + " " + e.getMessage(), e);
//						} catch (NoSuchAlgorithmException e) {
//							log.error(getName() + " " + e.getMessage(), e);
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
						log.info("\n" + getName() + " Il file [" + f.getAbsolutePath()
								+ "] risulta completamente elaborato");
						waiting(15, 10);
					}
				}
			}
		} else {
			log.error("\n" + getName() + " La cartella [" + pathExcel.getAbsolutePath() + "] non esiste");
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

	/**
	 * Metodo utilizzato per individuare il file per il trasferimento
	 * 
	 * @param pathDescriptati Path in cui si trovano i files da trasferire
	 * @param fileName        Nome del file da trasferire
	 * @param configuration   configurazione del programma centralizzato
	 * @return
	 */
	private File genFileTarGz(File pathDescriptati, String fileName, IMDConfiguration<Software> configuration)
			throws MDCheckException {
		File f = null;
		String extFilesUpload = null;
		String[] exts = null;
		String name = null;
		boolean trovato = false;

		try {
			extFilesUpload = configuration.getSoftwareConfigString("extFilesUpload");

			if (extFilesUpload != null) {
				exts = extFilesUpload.split(",");

				f = new File(pathDescriptati.getAbsolutePath() + File.separator + fileName);
				if (!f.exists()) {
					for (int x = 0; x < exts.length; x++) {
						f = new File(pathDescriptati.getAbsolutePath() + File.separator + fileName + "." + exts[x]);
						if (f.exists()) {
							break;
						}
					}
				} else {
					name = f.getName();
					for (int x = 0; x < exts.length; x++) {
						if (name.endsWith("." + exts[x])) {
							trovato = true;
							break;
						}
					}
					if (!trovato) {
						throw new MDCheckException("Il file [" + f.getAbsolutePath()
								+ "] non risulta della tipologia supportata [" + extFilesUpload + "]");
					}
				}
			}
		} catch (MDConfigurationException e) {
			log.error(e.getMessage(), e);
		} catch (MDCheckException e) {
			throw e;
		}

		return f;
	}

	protected abstract boolean analize(File fileTarGz, IMDConfiguration<Software> configuration)
			throws NoSuchAlgorithmException, FileNotFoundException, IOException, ClientMDException;

	protected abstract boolean isSender();
}
