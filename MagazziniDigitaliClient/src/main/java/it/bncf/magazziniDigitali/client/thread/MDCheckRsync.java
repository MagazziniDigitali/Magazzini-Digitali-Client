/**
 * 
 */
package it.bncf.magazziniDigitali.client.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDRsync;

/**
 * @author massi
 *
 */
public class MDCheckRsync extends MDCheck {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = Logger.getLogger(MDCheckRsync.class);

	private boolean sender = false;

	/**
	 * @param target
	 * @param name
	 * @param testMode
	 */
	public MDCheckRsync(Runnable target, String name, boolean testMode) {
		super(target, name, testMode);
	}

	@Override
	protected boolean analize(File fileTarGz) throws NoSuchAlgorithmException, FileNotFoundException, IOException, ClientMDException {
		ClientMDRsync clientMDRsync = null;

		try {
			clientMDRsync = new ClientMDRsync(fileTarGz);
			clientMDRsync.execute();
			sender = clientMDRsync.isSender();
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
		return false;
	}

	@Override
	protected boolean isSender() {
		return sender;
	}

	@Override
	protected File genFileTarGz(File pathDescriptati, String fileName) {
		File f = new File(
				pathDescriptati.getAbsolutePath()
				+ File.separator + fileName
				+ ".tar.gz");
		log.info("File da cercare: "+f.getAbsolutePath());
		return f;
	}

}
