/**
 * 
 */
package it.bncf.magazziniDigitali.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private Logger log = LogManager.getLogger(MDClient.class);

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
		boolean demonMode = false;
		
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
						System.out.println("   --demon (Opzionale) indica l'utilizzo della modalità Demone");
						System.exit(0);
					} else if (args[x].equals("--test")){
						testMode = true;
					} else if (args[x].equals("--demon")){
						demonMode = true;
					} else {
						pathProperties=args[x];
					}
				}
			}
			if (testMode && demonMode) {
				System.out.println("Non è possibile usare la modalità test e Demone contemporaneamente");
			}
			mdClient.start(pathProperties, testMode, demonMode);
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
	public void start(String pathProperties, boolean testMode, boolean demonMode) throws MDClientException{
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

			if ( testMode){
				System.out.println(printDateTime()+"Inizio elaborazione in Modalità di Test");
			} else if ( demonMode){
				System.out.println(printDateTime()+"Inizio elaborazione in Modalità di Demone");
			} else {
				System.out.println(printDateTime()+"Inizio elaborazione in Modalità Singola");
			}
			
			if (!demonMode) {
				System.out.println(printDateTime()+"\tInzio attività di trasferimento dati ");
			}
			configuration = new MDConfiguration("TD", "file:///"+pathProperties, sysPassword);
			mdCheckRsync = new MDCheckRsync(Thread.currentThread(), "RSync", testMode, demonMode, configuration);
			if (demonMode) {
				mdCheckRsync.start();
			} else {
				mdCheckRsync.run();
			}
			if (!demonMode) {
				System.out.println(printDateTime()+"\tFine attività di trasferimento dati ");
			}
			if (demonMode) {
				Thread.sleep(10000);
			}
			if (!demonMode) {
				System.out.println(printDateTime()+"\tInzio attività di verifica materiale trasferito");
			}
			mdCheckComplite = new MDCheckComplite(Thread.currentThread(), "Complete", testMode, demonMode, configuration);
			if (demonMode){
				mdCheckComplite.start();
			} else {
				mdCheckComplite.run();
			}
			if (!demonMode) {
				System.out.println(printDateTime()+"\tFine attività di verifica materiale trasferito");
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
				System.out.println(printDateTime()+"Fine elaborazione in Modalità di Test");
			} else if ( demonMode){
				System.out.println(printDateTime()+"Fine elaborazione in Modalità di Demone");
			} else {
				System.out.println(printDateTime()+"Fine elaborazione in Modalità Singola");
			}
		}
	}

	private String printDateTime() {
		String result = "";
		GregorianCalendar gc = null;
		SimpleDateFormat sdf = null;
		
		gc = new GregorianCalendar();
		sdf = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss.SSS zzzz", Locale.ITALIAN);
		result ="["+sdf.format(gc.getTime())+"]";
		return result+"\t";
	}
}
