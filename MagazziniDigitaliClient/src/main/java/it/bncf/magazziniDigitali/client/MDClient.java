/**
 * 
 */
package it.bncf.magazziniDigitali.client;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDRsync;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;

import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;

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
		
		try {
			mdClient = new MDClient();
			if (args.length>0){
				pathProperties=args[0];
			}
			mdClient.start(pathProperties);
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
	public void start(String pathProperties) throws ConfigurationException{
		Vector<String> pathInput = null;
		Vector<String> pathDescriptati = null;
		try {
			if (!Configuration.isInizialize()){
				Configuration.init(pathProperties);
			}
			pathInput =  (Vector<String>) Configuration.getValues("pathExcel");
			pathDescriptati =  (Vector<String>) Configuration.getValues("pathDescriptati");
			for (int x=0; x<pathInput.size(); x++){
				log.info("Analizzo la cartella ["+pathInput.get(x)+"]");
				checkExcel(new File(pathInput.get(x)), new File(pathDescriptati.get(x)));
			}
		} catch (ConfigurationException e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * Metodo utilizzato per testare il contenuto di una cartella
	 * 
	 * @param pathInput
	 */
	private void checkExcel(File pathExcel, File pathDescriptati){
		File[] fl = null;
		File f = null;
		File fElab = null;
		ClientMDRsync clientMDRsync = null;
		BufferedReader br = null;
		FileReader fr = null;
		String line = null;
		String[] st = null;
		File fileTarGz = null;

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
					try {
						fr = new FileReader(f);
						br = new BufferedReader(fr);
						while ((line=br.readLine())!= null){
							st = line.split("\t");
							fileTarGz = new File(pathDescriptati.getAbsolutePath()+File.separator+st[0]+".tar.gz");
							if (fileTarGz.exists()){
								try {
									clientMDRsync = new ClientMDRsync(fileTarGz);
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
							} else {
								log.error("Il file ["+fileTarGz.getAbsolutePath()+"] non esiste");
							}
						}
					} catch (FileNotFoundException e) {
						log.error(e.getMessage(), e);
					} catch (IOException e) {
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
				}
			}
		} else {
			log.error("La cartella ["+pathExcel.getAbsolutePath()+"] non esiste");
		}
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
