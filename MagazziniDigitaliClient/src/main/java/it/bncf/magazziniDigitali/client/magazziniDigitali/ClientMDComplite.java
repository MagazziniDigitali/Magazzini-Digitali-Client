/**
 * 
 */
package it.bncf.magazziniDigitali.client.magazziniDigitali;

import it.depositolegale.www.oggettiDigitali.StatoOggettoDigitale_type;
import it.depositolegale.www.readInfoOutput.ReadInfoOutput;
import it.depositolegale.www.webservice_confirmDelMD.ConfirmDelMDPortTypeProxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;

import org.apache.log4j.Logger;

/**
 * @author massi
 * 
 */
public class ClientMDComplite extends ClientMD {

	private Logger log = Logger.getLogger(ClientMDComplite.class);

	/**
	 * @param f
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ClientMDComplite(File f) throws NoSuchAlgorithmException,
			FileNotFoundException, IOException {
		super(f);
	}

	@Override
	protected void check(ReadInfoOutput checkMD) throws ClientMDException {
		log.info("NomeFile: "+checkMD.getOggettoDigitale().getNomeFile()+" StatoOggettoDigitale: "+checkMD.getOggettoDigitale().getStatoOggettoDigitale());
		if (checkMD.getOggettoDigitale().getStatoOggettoDigitale()
				.equals(StatoOggettoDigitale_type.ARCHIVIATO)) {
			try {
				log.info("deleteLocalFile: "+Configuration.getValue("md.deleteLocalFile"));
				if (Configuration.getValue("md.deleteLocalFile")
						.equalsIgnoreCase("true")) {
					// Il file risulta essere stato
					// archiviato correttamente su MD,
					// procedo con la cancellazione sul
					// disco locale
					if (!fSend.delete()) {
						throw new ClientMDException(
								"Riscontrato un problam nella cancellazione del file ["
										+ fSend.getAbsolutePath() + "]");
					}
					confirmDelMD(checkMD);
					completato = true;
				}
			} catch (ConfigurationException e) {
				throw new ClientMDException(e.getMessage(), e);
			}
		}
	}

	/**
	 * Metodo utilizzato per confermare la cancellazione dell'oggetto digitale
	 * dal client
	 * 
	 * @throws ClientMDException
	 */
	private void confirmDelMD(ReadInfoOutput input) throws ClientMDException {
		ConfirmDelMDPortTypeProxy proxy = null;

		try {
			proxy = new ConfirmDelMDPortTypeProxy(
					Configuration.getValue("md.wsdlConfirmDelMD"));

			proxy.confirmDelMDOperation(readInfoOutputToInput(input));
		} catch (RemoteException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new ClientMDException(e.getMessage(), e);
		}
	}

}
