/**
 * 
 */
package it.bncf.magazziniDigitali.client;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDRsync;

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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;
import mx.randalf.digest.MD5;

import org.apache.log4j.Logger;

/**
 * Interfaccia Client per la pubblicazione del matriale su Magazzini Digitali
 * 
 * @author massi
 *
 */
public class MDClient {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = Logger.getLogger(MDClient.class);

	/**
	 * Costruttore
	 */
	public MDClient() {
	}

	/**
	 * Metodo invocato quando la classe viene utilizzata come applicazione
	 * 
	 * @param args Lista degli argomenti passati
	 */
	public static void main(String[] args) {
		MDClient mdClient = null;
		String pathProperties = "."+File.separator;
		boolean testMode = false;
		
		try {
			mdClient = new MDClient();
			if (args.length>0){
				for (int x=0; x<args.length; x++){
					if (args[x].equalsIgnoreCase("-h") || 
							args[x].equalsIgnoreCase("-help") ||
							args[x].equalsIgnoreCase("--h") ||
							args[x].equalsIgnoreCase("--help") ||
							args[x].equalsIgnoreCase("/?")
							){
						System.out.println("Indicare i seguenti parametri:");
						System.out.println("1) Path del file di configurazione (Opzionale)");
						System.out.println("2) --test (Opzionale) indica l'utilizzo in modalità Test");
					} else if (args[x].equals("--test")){
						testMode = true;
					} else {
						pathProperties=args[x];
					}
				}
			}
			mdClient.start(pathProperties, testMode);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo utilizzato per eseguire l'analisi della cartella
	 * 
	 * @param pathProperties Path relativa alla posizione dei files di configurazione dell'applicazione
	 * @throws ConfigurationException 
	 */
	@SuppressWarnings("unchecked")
	public void start(String pathProperties, boolean testMode) throws ConfigurationException{
		Vector<String> pathInput = null;
		Vector<String> pathDescriptati = null;
		boolean sender= false;
		try {
			if ( testMode){
				System.out.println("Inizio elaborazione in Modalità di Test");
			}
			if (!Configuration.isInizialize()){
				Configuration.init(pathProperties);
			}
			pathInput =  (Vector<String>) Configuration.getValues("pathExcel");
			pathDescriptati =  (Vector<String>) Configuration.getValues("pathDescriptati");
			for (int x=0; x<pathInput.size(); x++){
				log.info("Analizzo la cartella ["+pathInput.get(x)+"]");
				sender = checkExcel(new File(pathInput.get(x)), new File(pathDescriptati.get(x)), testMode);
				if(testMode && sender){
					break;
				}
			}
		} catch (ConfigurationException e) {
			log.error(e);
			throw e;
		} finally {
			System.out.println("Fine elaborazione in Modalità di Test");
		}
	}

	/**
	 * Metodo utilizzato per testare il contenuto di una cartella
	 * 
	 * @param pathInput
	 */
	private boolean checkExcel(File pathExcel, File pathDescriptati, boolean testMode){
		File[] fl = null;
		File f = null;
		File fElab = null;
		ClientMDRsync clientMDRsync = null;
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
		boolean sender=false;

		if (pathExcel.exists()){
			fl = pathExcel.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File f) {
					boolean ris = false;
					
					// Verifico che il file/cartella non sia di tipo nascosto
					if (!f.getName().startsWith(".") && !f.isHidden()){
						// controllo se è una cartella
						if (f.getName().toLowerCase().endsWith(".txt")){
							ris = true;
						}
					}
					return ris;
				}
			});
			for (int x=0; x<fl.length; x++){
				f = fl[x];

				fElab = new File(f.getAbsolutePath()+".elab");
				if (!fElab.exists()){
					log.info("Elaboro il file ["+f.getAbsolutePath()+"]");
					try {
						md5 = new MD5();
						fr = new FileReader(f);
						br = new BufferedReader(fr);
						completato = true;
						while ((line=br.readLine())!= null){
							st = line.split("\t");
							fileTarGz = new File(pathDescriptati.getAbsolutePath()+File.separator+st[0]+".tar.gz");
							if (fileTarGz.exists()){
								try {
									log.info("Elaboro il file ["+fileTarGz.getAbsolutePath()+"]");
									clientMDRsync = new ClientMDRsync(fileTarGz);
									clientMDRsync.execute();
									completato = clientMDRsync.isCompletato();
									sender = true;
									log.info("Completato ["+completato+"] Inviato ["+clientMDRsync.isSender()+"]");
									if (testMode && clientMDRsync.isSender()){
										testComp=true;
										break;
									}
								} catch (NoSuchAlgorithmException e) {
									log.error(e.getMessage(), e);
									completato = false;
								} catch (FileNotFoundException e) {
									log.error(e.getMessage(), e);
									completato = false;
								} catch (IOException e) {
									log.error(e.getMessage(), e);
									completato = false;
								} catch (ClientMDException e) {
									log.error(e.getMessage(), e);
									completato = false;
								} catch (Exception e) {
									log.error(e.getMessage(), e);
									completato = false;
								} 
							} else {
								log.error("Il file ["+fileTarGz.getAbsolutePath()+"] non esiste");
								completato = false;
							}
						}
						if (completato){
							try {
								fw = new FileWriter(fElab);
								bw = new BufferedWriter(fw);
								bw.write(md5.getDigest(f)+"\t"+df.format(new Date(new GregorianCalendar().getTimeInMillis())));
							} catch (Exception e) {
								log.error(e.getMessage(), e);
							} finally {
								try {
									if (bw != null){
										bw.flush();
										bw.close();
									}
									if (fw != null){
										fw.close();
									}
								} catch (Exception e) {
									log.error(e.getMessage(), e);
								}
							}
							
						}
						if (testMode && testComp){
							break;
						}
					} catch (FileNotFoundException e) {
						log.error(e.getMessage(), e);
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					} catch (NoSuchAlgorithmException e) {
						log.error(e.getMessage(), e);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					} finally {
						try {
							if (br != null){
								br.close();
							}
							if (fr != null){
								fr.close();
							}
						} catch (IOException e) {
							log.error(e.getMessage(), e);
						}
					}
				} else {
					log.info("Il file ["+f.getAbsolutePath()+"] risulta completamente elaborato");
				}
			}
		} else {
			log.error("La cartella ["+pathExcel.getAbsolutePath()+"] non esiste");
		}
		return sender;
	}

	/**
	 * Metodo utilizzato per testare il contenuto di una cartella
	 * 
	 * @param pathInput
	private void checkFolder(File pathInput){
		File[] fl = null;
		File f = null;
		ClientMDRsync clientMDRsync = null;

		if (pathInput.exists()){
			fl = pathInput.listFiles(new FileFilter() {
				
				@SuppressWarnings("unchecked")
				@Override
				public boolean accept(File f) {
					boolean ris = false;
					Vector<String> st = null;
					
					// Verifico che il file/cartella non sia di tipo nascosto
					if (!f.getName().startsWith(".") && !f.isHidden()){
						// controllo se è una cartella
						if (f.isDirectory()){
							ris = true;
						} else {
							try {
								st = (Vector<String>) Configuration.getValues("file.extension");
								for (int x=0; x<st.size(); x++){
									if (f.getName().toLowerCase().endsWith(st.get(x).toLowerCase())){
										ris= true;
										break;
									}
								}
							} catch (ConfigurationException e) {
								log.error(e);
							}
						}
					}
					return ris;
				}
			});
			for (int x=0; x<fl.length; x++){
				f = fl[x];
				if (f.isDirectory()){
					checkFolder(f);
				} else {
					try {
						clientMDRsync = new ClientMDRsync(f);
						clientMDRsync.execute();
					} catch (NoSuchAlgorithmException e) {
						log.error(e.getMessage(), e);
					} catch (FileNotFoundException e) {
						log.error(e.getMessage(), e);
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					} catch (ClientMDException e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		} else {
			log.error("La cartella ["+pathInput.getAbsolutePath()+"] non esiste");
		}
	}
	 */
}
