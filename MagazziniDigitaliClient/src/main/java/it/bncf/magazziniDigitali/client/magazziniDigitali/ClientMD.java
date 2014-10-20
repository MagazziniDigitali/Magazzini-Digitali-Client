/**
 * 
 */
package it.bncf.magazziniDigitali.client.magazziniDigitali;

import it.depositolegale.www.istituto.StatoIstituto_type;
import it.depositolegale.www.oggettiDigitali.Digest;
import it.depositolegale.www.oggettiDigitali.Digest_type;
import it.depositolegale.www.readInfoInput.ReadInfoInput;
import it.depositolegale.www.readInfoInput.ReadInfoInputIstituto;
import it.depositolegale.www.readInfoInput.ReadInfoInputOggettoDigitale;
import it.depositolegale.www.readInfoOutput.ReadInfoOutput;
import it.depositolegale.www.webservice_checkMD.CheckMDPortTypeProxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;

import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;
import mx.randalf.digest.SHA1;

import org.apache.log4j.Logger;

/**
 * Questo metodo viene utilizzato per la gestione del colloquio con Magazzini
 * Digitali
 * 
 * @author massi
 * 
 */
abstract class ClientMD {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = Logger.getLogger(ClientMD.class);

	/**
	 * Variabile utilizzata per indicare il file da inviare
	 */
	protected File fSend = null;

	/**
	 * Variabile utilizzata per indicare il valore hash del file da inviare
	 */
	protected String hash = null;

	/**
	 * Variabile utilizzata per indicare l'ultima data di modifica del file
	 */
	protected GregorianCalendar lastModified = null;
	
	/**
	 * Variabile utilizzata per indicare che è stato completato il lavoro di pubblicazione sul file
	 */
	protected boolean completato = false;
	
	/**
	 * Variabile utilizzata per indicare che è stato inviato il file sul Server
	 */
	protected boolean sender = false;

	/**
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 */
	public ClientMD(File f) throws NoSuchAlgorithmException,
			FileNotFoundException, IOException {
		SHA1 digest = null;

		try {
			fSend = f;
			digest = new SHA1();
			hash = digest.getDigest(f);
			lastModified = new GregorianCalendar();
			lastModified.setTimeInMillis(f.lastModified());
		} catch (NoSuchAlgorithmException e) {
			throw e;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

	/**
	 * Metodo utilizzato per eseguire le operazioni di invio verso Magazzini
	 * Digitali compresi gli eventuali Test
	 * 
	 * @throws ClientMDException
	 * 
	 */
	public void execute() throws ClientMDException {
		ReadInfoOutput checkMD = null;
		boolean errori = false;

		// Richiesto all'interffacci MD lo stato dell'oggetto che devo inviare
		checkMD = checkMD();

		if (checkMD != null) {
			if (checkMD.getErrori() != null && checkMD.getErrori().length > 0) {
				for (int x = 0; x < checkMD.getErrori().length; x++) {
					log.error(checkMD.getErrori()[x].getId() + " - "
							+ checkMD.getErrori()[x].getMessaggio());
				}
			}
			if (checkMD.getWarning() != null && checkMD.getWarning().length > 0) {
				for (int x = 0; x < checkMD.getWarning().length; x++) {
					log.warn(checkMD.getWarning()[x].getId() + " - "
							+ checkMD.getWarning()[x].getMessaggio());
				}
			}
			if (checkMD.getInfo() != null && checkMD.getInfo().length > 0) {
				errori = true;
				for (int x = 0; x < checkMD.getInfo().length; x++) {
					log.info(checkMD.getInfo()[x].getId() + " - "
							+ checkMD.getInfo()[x].getMessaggio());
				}
			}
			if (!errori) {
				if (checkMD.getIstituto() != null) {
					if (checkMD.getIstituto().getStatoIstituto() != null) {
						if (checkMD.getIstituto().getStatoIstituto()
								.equals(StatoIstituto_type.VALIDO)) {
							if (checkMD.getOggettoDigitale() != null) {
								if (checkMD.getOggettoDigitale()
										.getStatoOggettoDigitale() != null) {
									
									check(checkMD);
									
								} else {
									throw new ClientMDException(
											"Non risultano validato l'oggetto Digitale");
								}
							} else {
								throw new ClientMDException(
										"Non risultano le informazioni dell'oggetto digitale");
							}
						} else {
							throw new ClientMDException(
									"Stato dell'istituto non presente");
						}
					} else {
						throw new ClientMDException(
								"Stato dell'istituto ["+checkMD.getIstituto().getStatoIstituto()+"]");
					}
				} else {
					throw new ClientMDException(
							"Non risultano le informazioni dell'istituto");
				}
			}
		} else {
			throw new ClientMDException(
					"Riscontrato un problema l'interrogazione del Magazzino Digitale");
		}
	}

	protected abstract void check(ReadInfoOutput checkMD) throws ClientMDException;

	/**
	 * Metodo utilizzato per la trasformazione del traccoato ReadInfoOutput in ReadInfoInput
	 * 
	 * @param output Traccoato ReadInfoOutput
	 * @return Tracciato ReadInfoInput
	 */
	protected ReadInfoInput readInfoOutputToInput(ReadInfoOutput output){
		ReadInfoInput intput = null;
		intput = new ReadInfoInput();
		intput.setIstituto(new ReadInfoInputIstituto(output
				.getIstituto().getId(), output.getIstituto().getNome(), output
				.getIstituto().getPassword(), output.getIstituto()
				.getStatoIstituto()));
		intput.setOggettoDigitale(new ReadInfoInputOggettoDigitale(
				output.getOggettoDigitale().getId(), output
						.getOggettoDigitale().getNomeFile(), output
						.getOggettoDigitale().getDigest(), output
						.getOggettoDigitale().getUltimaModifica(), output
						.getOggettoDigitale().getStatoOggettoDigitale()));
		return intput;
	}

	/**
	 * Metodo utilizzato per la verifica dello stato dell'oggetto su MD
	 * 
	 * @return Esito della verifica
	 * @throws ClientMDException
	 */
	private ReadInfoOutput checkMD() throws ClientMDException {
		CheckMDPortTypeProxy proxy = null;
		ReadInfoInput input = null;
		ReadInfoOutput output = null;
		ReadInfoInputIstituto istituto = null;
		ReadInfoInputOggettoDigitale oggettoDigitale = null;
		Digest[] digest = null;

		try {
			log.info("checkMD: "+Configuration.getValue("md.wsdlCheckMD")+" sha1: "+hash);
			proxy = new CheckMDPortTypeProxy(
					Configuration.getValue("md.wsdlCheckMD"));

			input = new ReadInfoInput();

			log.debug("istituto.id: "+Configuration.getValue("istituto.id"));
			log.debug("istituto.password: "+Configuration.getValue("istituto.password"));
			istituto = new ReadInfoInputIstituto();
			istituto.setId(Configuration.getValue("istituto.id"));
			istituto.setPassword(Configuration.getValue("istituto.password"));
			input.setIstituto(istituto);

			log.debug("digest: "+digest);
			log.debug("lastModified: "+lastModified);
			oggettoDigitale = new ReadInfoInputOggettoDigitale();
			oggettoDigitale.setNomeFile(fSend.getName());
			digest = new Digest[1];
			digest[0] = new Digest();
			digest[0].setDigestType(Digest_type.SHA1);
			digest[0].setDigestValue(hash);
			oggettoDigitale.setDigest(digest);
			oggettoDigitale.setUltimaModifica(lastModified);
			input.setOggettoDigitale(oggettoDigitale);
			output = proxy.checkMDOperation(input);
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		} catch (RemoteException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		}
		return output;
	}

	public boolean isCompletato() {
		return completato;
	}

	public boolean isSender() {
		return sender;
	}
}
