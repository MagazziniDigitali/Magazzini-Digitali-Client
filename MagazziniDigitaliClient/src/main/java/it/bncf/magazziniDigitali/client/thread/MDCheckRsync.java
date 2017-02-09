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
	private Logger log = Logger.getLogger(MDCheckRsync.class);

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
		File f = null;
		String[] exts = new String[4];
		
		exts[0]=".tar.gz";
		exts[1]=".tgz";
		exts[2]=".tar";
		exts[3]=".warc.gz";

		for (int x=0; x<exts.length; x++){
			f = new File(
					pathDescriptati.getAbsolutePath()
					+ File.separator + fileName
					+ exts[x]);
			if (f.exists()){
				break;
			}
		}
//		if (!f.exists()){
//			f = new File(
//					pathDescriptati.getAbsolutePath()
//					+ File.separator + fileName
//					+ ".tgz");
//			if (!f.exists()){
//				f = new File(
//						pathDescriptati.getAbsolutePath()
//						+ File.separator + fileName
//						+ ".tar");
//			}
//		}
//		log.info("File da cercare: "+f.getAbsolutePath());
		return f;
	}

}
