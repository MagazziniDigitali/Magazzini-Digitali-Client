package it.bncf.magazziniDigitali.client.thread;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDComplite;
import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class MDCheckComplite extends MDCheck {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = Logger.getLogger(MDCheckComplite.class);

	public MDCheckComplite(Runnable target, String name, boolean testMode) {
		super(target, name, testMode);
	}

	@Override
	protected boolean analize(File fileTarGz) throws NoSuchAlgorithmException,
			FileNotFoundException, IOException, ClientMDException {
		ClientMDComplite clientMDRsync = null;
		boolean completato = false;

		try {
			clientMDRsync = new ClientMDComplite(fileTarGz);
			clientMDRsync.execute();
			completato = clientMDRsync.isCompletato();
			log.info(getName()+" Completato ["+clientMDRsync.isCompletato()+"] Inviato ["+clientMDRsync.isSender()+"]");
		} catch (NoSuchAlgorithmException e) {
			throw e;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (ClientMDException e) {
			throw e;
		}
		return completato;
	}

	@Override
	protected boolean isSender() {
		return true;
	}

	@Override
	protected File genFileTarGz(File pathDescriptati, String fileName) {
		return new File(
				pathDescriptati.getAbsolutePath()
						+ File.separator + fileName
						+ ".tar.gz");
	}

}
