/**
 * 
 */
package it.bncf.magazziniDigitali.client.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDRsync;
import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.depositolegale.www.software.Software;

/**
 * @author massi
 *
 */
public class MDCheckRsync extends MDCheck {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = LogManager.getLogger(MDCheckRsync.class);

	private boolean sender = false;

	/**
	 * @param target
	 * @param name
	 * @param testMode
	 */
	public MDCheckRsync(Runnable target, String name, boolean testMode, IMDConfiguration<Software> configuration) {
		super(target, name, testMode, configuration);
	}

	@Override
	protected boolean analize(File fileTarGz, IMDConfiguration<Software> configuration) throws NoSuchAlgorithmException, FileNotFoundException, IOException, ClientMDException {
		ClientMDRsync clientMDRsync = null;

		try {
			clientMDRsync = new ClientMDRsync(fileTarGz);
			clientMDRsync.execute(configuration);
			sender = clientMDRsync.isSender();
			log.info("\n"+getName()+" Completato ["+clientMDRsync.isCompletato()+"] Inviato ["+clientMDRsync.isSender()+"]");
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
	protected void postElab(File pathElab) {
		// TODO Auto-generated method stub
		
	}

}
