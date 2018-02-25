/**
 * 
 */
package it.bncf.magazziniDigitali.client.magazziniDigitali;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import java.util.Vector;

import org.apache.commons.httpclient.protocol.DefaultProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.log4j.Logger;

import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.bncf.magazziniDigitali.configuration.exception.MDConfigurationException;
import it.depositolegale.software.ConverterReadInfoInputSoftware;
import it.depositolegale.www.oggettiDigitali.Digest;
import it.depositolegale.www.oggettiDigitali.Digest_type;
import it.depositolegale.www.readInfoInput.ReadInfoInput;
import it.depositolegale.www.readInfoInput.ReadInfoInputOggettoDigitale;
import it.depositolegale.www.readInfoOutput.ReadInfoOutput;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.webservice_checkMD.CheckMDPortTypeProxy;
import mx.randalf.digest.MD5;
import mx.randalf.digest.SHA1;
import mx.randalf.digest.SHA256;

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
	protected Vector<Digest> digests = null;

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
		MD5 md5 = null;
		SHA1 sha1 = null;
//		SHA256 sha256 = null;

		try {
			fSend = f;
			digests = new Vector<Digest>();

			md5 = new MD5(f);
			digests.add(new Digest(Digest_type.value3, md5.getDigest()));
			digests.add(new Digest(Digest_type.value4, md5.getDigest64Base()));

			sha1 = new SHA1(f);
			digests.add(new Digest(Digest_type.value2, sha1.getDigest()));
			digests.add(new Digest(Digest_type.value5, sha1.getDigest64Base()));

//			sha256 = new SHA256(f);
//			digests.add(new Digest(Digest_type.value1, sha256.getDigest()));
//			digests.add(new Digest(Digest_type.value6, sha256.getDigest64Base()));
			
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
	public void execute(IMDConfiguration<Software> configuration) throws ClientMDException {
		ReadInfoOutput checkMD = null;
		boolean errori = false;

		// Richiesto all'interffacci MD lo stato dell'oggetto che devo inviare
		checkMD = checkMD(configuration);

		if (checkMD != null) {
			if (checkMD.getErrori() != null && checkMD.getErrori().length > 0) {
				for (int x = 0; x < checkMD.getErrori().length; x++) {
					log.error("\n"+checkMD.getErrori()[x].getId() + " - "
							+ checkMD.getErrori()[x].getMessaggio());
				}
			}
			if (checkMD.getWarning() != null && checkMD.getWarning().length > 0) {
				for (int x = 0; x < checkMD.getWarning().length; x++) {
					log.warn("\n"+checkMD.getWarning()[x].getId() + " - "
							+ checkMD.getWarning()[x].getMessaggio());
				}
			}
			if (checkMD.getInfo() != null && checkMD.getInfo().length > 0) {
				errori = true;
				for (int x = 0; x < checkMD.getInfo().length; x++) {
					log.info("\n"+checkMD.getInfo()[x].getId() + " - "
							+ checkMD.getInfo()[x].getMessaggio());
				}
			}
			if (!errori) {
				if (checkMD.getOggettoDigitale() != null) {
					if (checkMD.getOggettoDigitale()
							.getStatoOggettoDigitale() != null) {
						
						check(checkMD, configuration);
						
					} else {
						throw new ClientMDException(
								"Non risultano validato l'oggetto Digitale");
					}
				} else {
					throw new ClientMDException(
							"Non risultano le informazioni dell'oggetto digitale");
				}
			}
		} else {
			throw new ClientMDException(
					"Riscontrato un problema l'interrogazione del Magazzino Digitale");
		}
	}

	protected abstract void check(ReadInfoOutput checkMD, IMDConfiguration<Software> configuration) throws ClientMDException;

	/**
	 * Metodo utilizzato per la trasformazione del traccoato ReadInfoOutput in ReadInfoInput
	 * 
	 * @param output Traccoato ReadInfoOutput
	 * @return Tracciato ReadInfoInput
	 */
	protected ReadInfoInput readInfoOutputToInput(ReadInfoOutput output){
		ReadInfoInput intput = null;
		intput = new ReadInfoInput();
		ConverterReadInfoInputSoftware converterReadInfoInputSoftware = null;
		
		converterReadInfoInputSoftware = new ConverterReadInfoInputSoftware();
		
		intput.setSoftware(converterReadInfoInputSoftware.convert(output.getSoftware()));
//		intput.setIstituto(new ReadInfoInputIstituto(output
//				.getIstituto().getId(), output.getIstituto().getNome(), output
//				.getIstituto().getPassword(), output.getIstituto()
//				.getStatoIstituto()));
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
	private ReadInfoOutput checkMD(IMDConfiguration<Software> configuration) throws ClientMDException {
		CheckMDPortTypeProxy proxy = null;
		ReadInfoInput input = null;
		ReadInfoOutput output = null;
//		ReadInfoInputIstituto istituto = null;
		ReadInfoInputOggettoDigitale oggettoDigitale = null;
		String wsdlCheckMD = null;
		ConverterReadInfoInputSoftware converterReadInfoInputSoftware = null;

		try {
			wsdlCheckMD = configuration.getSoftwareConfigString("wsdlCheckMD");
			if (wsdlCheckMD.toLowerCase().trim().startsWith("https")){
				Protocol.registerProtocol("https", 
						new Protocol("https", new DefaultProtocolSocketFactory(), 443));
			}
			//Configuration.getValue("md.wsdlCheckMD")
			log.info("\n"+"checkMD: "+wsdlCheckMD);
			proxy = new CheckMDPortTypeProxy(wsdlCheckMD);

			input = new ReadInfoInput();

			converterReadInfoInputSoftware = new ConverterReadInfoInputSoftware();
			input.setSoftware(converterReadInfoInputSoftware.convert(configuration.getSoftware()));

			log.debug("\n"+"digest: "+digests);
			log.debug("\n"+"lastModified: "+lastModified);
			oggettoDigitale = new ReadInfoInputOggettoDigitale();
			oggettoDigitale.setNomeFile(fSend.getName());
			oggettoDigitale.setDigest(digests.toArray(new Digest[digests.size()]));
			oggettoDigitale.setUltimaModifica(lastModified);
			input.setOggettoDigitale(oggettoDigitale);
			output = proxy.checkMDOperation(input);
		} catch (MDConfigurationException e) {
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
