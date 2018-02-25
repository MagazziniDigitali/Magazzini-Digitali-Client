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
			log.error(e.getMessage(),e);
			throw new MDClientException(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
			throw new MDClientException(e.getMessage(), e);
		} catch (MDConfigurationException e) {
			log.error(e.getMessage(),e);
			throw new MDClientException(e.getMessage(), e);
		} finally {
			if ( testMode){
				System.out.println("Fine elaborazione in Modalità di Test");
			}
		}
	}
}
