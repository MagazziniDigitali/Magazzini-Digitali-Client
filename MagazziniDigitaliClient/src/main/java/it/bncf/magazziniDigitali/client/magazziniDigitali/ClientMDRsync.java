/**
 * 
 */
package it.bncf.magazziniDigitali.client.magazziniDigitali;


import it.depositolegale.www.endSend.EndSend;
import it.depositolegale.www.endSend.EndSendReadInfoOutput;
import it.depositolegale.www.endSend.EndSendReadInfoOutputIstituto;
import it.depositolegale.www.endSend.EndSendReadInfoOutputOggettoDigitale;
import it.depositolegale.www.oggettiDigitali.StatoOggettoDigitale_type;
import it.depositolegale.www.readInfoOutput.Errori;
import it.depositolegale.www.readInfoOutput.ReadInfoOutput;
import it.depositolegale.www.webservice_endSendMD.EndSendMDPortTypeProxy;
import it.depositolegale.www.webservice_initSendMD.InitSendMDPortTypeProxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;

import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;

import org.apache.log4j.Logger;

/**
 * @author massi
 * 
 */
public class ClientMDRsync extends ClientMD{

	private Logger log = Logger.getLogger(ClientMDRsync.class);

	/**
	 * @param f
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ClientMDRsync(File f) throws NoSuchAlgorithmException,
			FileNotFoundException, IOException {
		super(f);
	}

	/**
	 * @see it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMD#send(java.io.File,
	 *      java.lang.String, java.util.GregorianCalendar)
	 */
	private void send(File fSend, String hash, GregorianCalendar lastModified)
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
		String fileInput = null;

		try {
			log.info("Invio file: "+fSend.getAbsolutePath());
			rt = Runtime.getRuntime();
			if (File.separator.equals("\\")){
				fileInput = "/cygdrive/"+fSend.getAbsolutePath().replace(":", "").replace("\\", "/");
			} else {
				fileInput = fSend.getAbsolutePath();
			}
			cmd = new String[] { Configuration.getValue("md.sendRsync.path"), 
					"-av", 
					"--progress",
					fileInput,
					Configuration.getValue("md.sendRsync") };

			proc = rt.exec(cmd, new String[]{"RSYNC_PASSWORD="+Configuration.getValue("md.sendRsyncPwd")});

			stderr = proc.getErrorStream();
			isrErr = new InputStreamReader(stderr);
			brErr = new BufferedReader(isrErr);

			stdout = proc.getInputStream();
			isrStd = new InputStreamReader(stdout);
			brStd = new BufferedReader(isrStd);

			while ((val = brStd.readLine()) != null) {
				log.debug(val);
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
				log.info("File: "+fSend.getAbsolutePath()+" inviato");
			} catch (IOException e) {
				throw new ClientMDException(e.getMessage(), e);
			}
		}
	}

	@Override
	protected void check(ReadInfoOutput checkMD) throws ClientMDException {
		if (checkMD
				.getOggettoDigitale()
				.getStatoOggettoDigitale()
				.equals(StatoOggettoDigitale_type.INITTRASF) ||
				checkMD
				.getOggettoDigitale()
				.getStatoOggettoDigitale()
				.equals(StatoOggettoDigitale_type.NONPRESENTE)) {
			if (checkMD
					.getOggettoDigitale()
					.getStatoOggettoDigitale()
					.equals(StatoOggettoDigitale_type.NONPRESENTE)) {
				// L'oggetto non risulta essere inviato
				// in Magazzini Digitali, procedo con
				// l'invio
				checkMD = initSendMD(checkMD);
			}
			try {
				send(fSend, hash, lastModified);
				endSendMD(checkMD, true, null);
				sender=true;
			} catch (ClientMDException e) {
				log.error(
						"File ["
								+ fSend.getAbsolutePath()
								+ "] Msg ["
								+ e.getMessage()
								+ "]", e);
				endSendMD(checkMD, false,
						e.getMessage());
			}
		}
	}

	/**
	 * Metodo utilizzato per indicare a MD che stiamo iniziando l'invio di un
	 * oggetto digitale
	 * 
	 * @return Identificativo temporaneo associato all'oggetto
	 * @throws ClientMDException 
	 */
	private ReadInfoOutput initSendMD(ReadInfoOutput input) throws ClientMDException {
		InitSendMDPortTypeProxy proxy = null;
		ReadInfoOutput output = null;

		try {
			proxy = new InitSendMDPortTypeProxy(
					Configuration.getValue("md.wsdlInitSendMD"));

			output = proxy.initSendMDOperation(readInfoOutputToInput(input));
		} catch (RemoteException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		}
		return output;
	}

	/**
	 * Metodo utulizzato per indicare a MD la fine del file della procedura di
	 * pubblicazione
	 * 
	 * @param input
	 *            Informazioni relative agli oggetti digitali
	 * @param esito
	 *            Esito dell'invio
	 * @param msgErr
	 *            Eventuale messaggio di errore
	 * @throws ClientMDException 
	 */
	private void endSendMD(ReadInfoOutput input, boolean esito, String msgErr) throws ClientMDException {
		EndSendMDPortTypeProxy proxy = null;
		EndSend endSend = null;
		Errori[] errori = null;

		try {
			proxy = new EndSendMDPortTypeProxy(
					Configuration.getValue("md.wsdlEndSendMD"));

			endSend = new EndSend();
			endSend.setReadInfoOutput(
					new EndSendReadInfoOutput(
							new EndSendReadInfoOutputIstituto(
									input.getIstituto().getId(), 
									input.getIstituto().getNome(), 
									input.getIstituto().getPassword(), 
									input.getIstituto().getStatoIstituto()) , 
							new EndSendReadInfoOutputOggettoDigitale(
									input.getOggettoDigitale().getId(), 
									input.getOggettoDigitale().getNomeFile(), 
									input.getOggettoDigitale().getDigest(), 
									input.getOggettoDigitale().getUltimaModifica(), 
									input.getOggettoDigitale().getStatoOggettoDigitale()), 
							input.getErrori(), 
							input.getWarning(), 
							input.getInfo()));
			endSend.setEsito(esito);
			if (msgErr!= null){
				errori = new Errori[1];
				errori[0]= new Errori(null, msgErr);
				endSend.setErrori(errori);
			}
			proxy.endSendMDOperation(endSend);
		} catch (RemoteException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		}
	}

}
