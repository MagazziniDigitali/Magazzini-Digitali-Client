package it.bncf.magazziniDigitali.client.thread;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDComplite;
import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;
import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.depositolegale.www.software.Software;

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
			log.info(getName()+" Completato ["+clientMDComplite.isCompletato()+"] Inviato ["+clientMDComplite.isSender()+"]");
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
//		File fOut = null;
//		
//		fOut = new File(
//				pathDescriptati.getAbsolutePath()
//				+ File.separator + fileName
//				+ ".tar.gz");
//		if (!fOut.exists()){
//			fOut = new File(
//					pathDescriptati.getAbsolutePath()
//					+ File.separator + fileName
//					+ ".tgz");
//			if (!fOut.exists()){
//				fOut = new File(
//						pathDescriptati.getAbsolutePath()
//						+ File.separator + fileName
//						+ ".tar");
//			}
//		}
		return f;
	}

}
