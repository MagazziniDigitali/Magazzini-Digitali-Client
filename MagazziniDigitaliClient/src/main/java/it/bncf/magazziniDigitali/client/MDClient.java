/**
 * 
 */
package it.bncf.magazziniDigitali.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import it.bncf.magazziniDigitali.client.exception.MDClientException;
import it.bncf.magazziniDigitali.client.thread.MDCheckComplite;
import it.bncf.magazziniDigitali.client.thread.MDCheckRsync;
import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.bncf.magazziniDigitali.configuration.exception.MDConfigurationException;
import it.depositolegale.configuration.MDConfiguration;
import it.depositolegale.www.software.Software;

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

	private MDCheckComplite mdCheckComplite;
	private MDCheckRsync mdCheckRsync;
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
						System.exit(0);
					} else if (args[x].equals("--test")){
						testMode = true;
					} else {
						pathProperties=args[x];
					}
				}
			}
			mdClient.start(pathProperties, testMode);
		} catch (MDClientException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo utilizzato per eseguire l'analisi della cartella
	 * 
	 * @param pathProperties Path relativa alla posizione dei files di configurazione dell'applicazione
	 * @throws MDClientException 
	 */
	public void start(String pathProperties, boolean testMode) throws MDClientException{
		IMDConfiguration<Software> configuration = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		String sysPassword = null;
		
		try {
			
			
			if (System.getenv("MDCLIENT_PWD") != null){
				sysPassword = System.getenv("MDCLIENT_PWD");
			} else {
				System.out.println("Indicare la password per la connessione con MD");
				
				isr = new InputStreamReader(System.in);
				br = new BufferedReader(isr);
				sysPassword = br.readLine();
			}
			
			configuration = new MDConfiguration("TD", "file:///"+pathProperties, sysPassword);
			if ( testMode){
				System.out.println("Inizio elaborazione in Modalità di Test");
			}
//			if (!Configuration.isInizialize()){
//				Configuration.init(pathProperties);
//			}
			mdCheckRsync = new MDCheckRsync(Thread.currentThread(), "RSync", testMode, configuration);
			if (testMode){
				mdCheckRsync.run();
			} else {
				mdCheckRsync.start();
			}
			Thread.sleep(10000);
			mdCheckComplite = new MDCheckComplite(Thread.currentThread(), "Complete", testMode, configuration);
			if (testMode){
				mdCheckComplite.run();
			} else {
				mdCheckComplite.start();
			}
		} catch (InterruptedException e) {
			log.error(e);
			throw new MDClientException(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e);
			throw new MDClientException(e.getMessage(), e);
		} catch (MDConfigurationException e) {
			log.error(e);
			throw new MDClientException(e.getMessage(), e);
		} finally {
			if ( testMode){
				System.out.println("Fine elaborazione in Modalità di Test");
			}
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
