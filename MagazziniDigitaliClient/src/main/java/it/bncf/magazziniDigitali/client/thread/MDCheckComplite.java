package it.bncf.magazziniDigitali.client.thread;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDComplite;
import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.bncf.magazziniDigitali.utils.folder.FolderSyncElab;
import it.depositolegale.www.software.Software;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MDCheckComplite extends MDCheck {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private Logger log = LogManager.getLogger(MDCheckComplite.class);

	public MDCheckComplite(Runnable target, String name, boolean testMode, IMDConfiguration<Software> configuration) {
		super(target, name, testMode, configuration);
	}

	@Override
	protected boolean analize(File fileTarGz, IMDConfiguration<Software> configuration) throws NoSuchAlgorithmException,
			FileNotFoundException, IOException, ClientMDException {
		ClientMDComplite clientMDComplite = null;
		boolean completato = false;

		try {
			clientMDComplite = new ClientMDComplite(fileTarGz);
			clientMDComplite.execute(configuration);
			completato = clientMDComplite.isCompletato();
			log.info("\n"+getName()+" Completato ["+clientMDComplite.isCompletato()+"] Inviato ["+clientMDComplite.isSender()+"]");
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
	protected void postElab(File pathElab) {
		FolderSyncElab folderSyncElab = null;

		folderSyncElab = new FolderSyncElab(pathElab);
		folderSyncElab.syncElab();
	}

}
