package it.bncf.magazziniDigitali.client.test.checkMD;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;

import org.apache.log4j.Logger;

public class ClientMDRsyncTest {

	public static Logger log = Logger.getLogger(ClientMDRsyncTest.class);

	public ClientMDRsyncTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		
		try {
			Configuration.init(args[0]);
			
			ClientMDRsyncTest.send(new File(args[1]));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (ClientMDException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMD#send(java.io.File,
	 *      java.lang.String, java.util.GregorianCalendar)
	 */
	public static  void send(File fSend)
			throws ClientMDException {
		Runtime rt = null;
		Process proc = null;
		String[] cmd = null;
		InputStream stderr = null;
		InputStreamReader isrErr = null;
		BufferedReader brErr = null;
		InputStream stdout = null;
		InputStreamReader isrStd = null;
		BufferedReader brStd = null;
		String val = null;
		int exitVal = -1;

		try {
			log.info("Invio file: "+fSend.getAbsolutePath());
			rt = Runtime.getRuntime();
			cmd = new String[] { Configuration.getValue("md.sendRsync.path"), 
					"-av", 
					"--progress",
					fSend.getAbsolutePath(),
					Configuration.getValue("md.sendRsync") };

			proc = rt.exec(cmd, new String[]{"RSYNC_PASSWORD="+Configuration.getValue("md.sendRsyncPwd")});

			stderr = proc.getErrorStream();
			isrErr = new InputStreamReader(stderr);
			brErr = new BufferedReader(isrErr);

			stdout = proc.getInputStream();
			isrStd = new InputStreamReader(stdout);
			brStd = new BufferedReader(isrStd);

			while ((val = brStd.readLine()) != null) {
				log.info(val);
			}

			while ((val = brErr.readLine()) != null) {
				log.error(val);
			}

			exitVal = proc.waitFor();

			switch (exitVal) {
			case 0:
				break;
			case 1:
				throw new ClientMDException("Errore di sintassi o l'utilizzo");
			case 2:
				throw new ClientMDException("Protocollo di incompatibilità");
			case 3:
				throw new ClientMDException(
						"Errori di selezione dei file di input / output, dirs");
			case 4:
				throw new ClientMDException(
						"L'azione richiesta non è supportata: un tentativo è stato fatto per manipolare file a 64 bit su una piattaforma che non li può sostenere, o un'opzione stato precisato che è supportato dal client e non dal server.");
			case 5:
				throw new ClientMDException(
						"Errore durante l'avvio del protocollo client-server");
			case 6:
				throw new ClientMDException(
						"Daemon in grado di aggiungere al log-file");
			case 10:
				throw new ClientMDException("Errore in socket I/O");
			case 11:
				throw new ClientMDException("Errore in file I/O");
			case 12:
				throw new ClientMDException(
						"Errore nei rsync flusso di dati del protocollo");
			case 13:
				throw new ClientMDException(
						"Errori con diagnostica del programma");
			case 14:
				throw new ClientMDException("Errore nel codice IPC");
			case 20:
				throw new ClientMDException("Ricevuto SIGUSR1 o SIGINT");
			case 21:
				throw new ClientMDException(
						"Qualche errore restituito da waitpid()");
			case 22:
				throw new ClientMDException(
						"Buffer di memoria centrale che ripartisce errore");
			case 23:
				throw new ClientMDException(
						"Trasferimento parziale a causa di un errore");
			case 24:
				throw new ClientMDException(
						"Trasferimento parziale a causa di file di origine scomparsi");
			case 25:
				throw new ClientMDException(
						"Il limite --max-delete a fermato eliminazioni");
			case 30:
				throw new ClientMDException(
						"Timeout nei dati di invio / ricezione");
			case 255:
				throw new ClientMDException(
						"Autorizzazione negata, riprova.");
			default:
				throw new ClientMDException(
						"Errore generico ["+exitVal+"]");
			}
		} catch (ClientMDException e) {
			throw e;
		} catch (ConfigurationException e) {
			throw new ClientMDException(e.getMessage(), e);
		} catch (IOException e) {
			throw new ClientMDException(e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new ClientMDException(e.getMessage(), e);
		} finally {
			try {
				if (brStd!= null){
					brStd.close();
				}
				if (isrStd != null){
					isrStd.close();
				}
				if (stdout != null){
					stdout.close();
				}
				if (brErr != null){
					brErr.close();
				}
				if (isrErr != null){
					isrErr.close();
				}
				if (stderr != null){
					stderr.close();
				}
			} catch (IOException e) {
				throw new ClientMDException(e.getMessage(), e);
			}
		}
	}
}
