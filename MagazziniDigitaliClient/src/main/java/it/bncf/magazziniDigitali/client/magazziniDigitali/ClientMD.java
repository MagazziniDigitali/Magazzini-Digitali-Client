/**
 * 
 */
package it.bncf.magazziniDigitali.client.magazziniDigitali;

import it.depositolegale.www.endSend.EndSend;
import it.depositolegale.www.endSend.EndSendReadInfoOutput;
import it.depositolegale.www.endSend.EndSendReadInfoOutputIstituto;
import it.depositolegale.www.endSend.EndSendReadInfoOutputOggettoDigitale;
import it.depositolegale.www.istituto.StatoIstituto_type;
import it.depositolegale.www.oggettiDigitali.Digest;
import it.depositolegale.www.oggettiDigitali.Digest_type;
import it.depositolegale.www.oggettiDigitali.StatoOggettoDigitale_type;
import it.depositolegale.www.readInfoInput.ReadInfoInput;
import it.depositolegale.www.readInfoInput.ReadInfoInputIstituto;
import it.depositolegale.www.readInfoInput.ReadInfoInputOggettoDigitale;
import it.depositolegale.www.readInfoOutput.Errori;
import it.depositolegale.www.readInfoOutput.ReadInfoOutput;
import it.depositolegale.www.webservice_checkMD.CheckMDPortTypeProxy;
import it.depositolegale.www.webservice_confirmDelMD.ConfirmDelMDPortTypeProxy;
import it.depositolegale.www.webservice_endSendMD.EndSendMDPortTypeProxy;
import it.depositolegale.www.webservice_initSendMD.InitSendMDPortTypeProxy;

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
	private Logger log = Logger.getLogger(getClass());

	/**
	 * Variabile utilizzata per indicare il file da inviare
	 */
	private File fSend = null;

	/**
	 * Variabile utilizzata per indicare il valore hash del file da inviare
	 */
	private String hash = null;

	/**
	 * Variabile utilizzata per indicare l'ultima data di modifica del file
	 */
	private GregorianCalendar lastModified = null;
	
	/**
	 * Variabile utilizzata per indicare che è stato completato il lavoro di pubblicazione sul file
	 */
	private boolean completato = false;
	
	/**
	 * Variabile utilizzata per indicare che è stato inviato il file sul Server
	 */
	private boolean sender = false;

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
									} else if (checkMD
											.getOggettoDigitale()
											.getStatoOggettoDigitale()
											.equals(StatoOggettoDigitale_type.ARCHIVIATO)) {
										try {
											if (Configuration.getValue("md.deleteLocalFile").equalsIgnoreCase("true")){
												// Il file risulta essere stato
												// archiviato correttamente su MD,
												// procedo con la cancellazione sul
												// disco locale
												if (!fSend.delete()) {
													throw new ClientMDException(
															"Riscontrato un problam nella cancellazione del file ["
																	+ fSend.getAbsolutePath()
																	+ "]");
												}
												confirmDelMD(checkMD);
												completato=true;
											}
										} catch (ConfigurationException e) {
											throw new ClientMDException(e.getMessage(), e);
										}
									}
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

	/**
	 * Metodo utilizzato per confermare la cancellazione dell'oggetto digitale
	 * dal client
	 * @throws ClientMDException 
	 */
	private void confirmDelMD(ReadInfoOutput input) throws ClientMDException {
		ConfirmDelMDPortTypeProxy proxy = null;

		try {
			proxy = new ConfirmDelMDPortTypeProxy(Configuration.getValue("md.wsdlConfirmDelMD"));
			
			proxy.confirmDelMDOperation(readInfoOutputToInput(input));
		} catch (RemoteException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		}
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

	/**
	 * Metodo da implementare le l'invio dell'oggetto a MD
	 * 
	 * @param fSend
	 *            Oggetto da inviare
	 * @param hash
	 *            chiave Sha1 ralativa all'oggetto da inviare
	 * @param lastModified
	 *            Data e ora dell'ultima modifica dell'oggetto da inviare
	 */
	protected abstract void send(File fSend, String hash,
			GregorianCalendar lastModified) throws ClientMDException;

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
	 * Metodo utilizzato per la trasformazione del traccoato ReadInfoOutput in ReadInfoInput
	 * 
	 * @param output Traccoato ReadInfoOutput
	 * @return Tracciato ReadInfoInput
	 */
	private ReadInfoInput readInfoOutputToInput(ReadInfoOutput output){
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
