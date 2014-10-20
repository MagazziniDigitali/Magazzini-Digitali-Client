/**
 * 
 */
package it.bncf.magazziniDigitali.client.thread;

import it.bncf.magazziniDigitali.client.magazziniDigitali.ClientMDException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author massi
 *
 */
public class MDCheckRsyncCoda extends MDCheck {

	/**
	 * @param target
	 * @param name
	 * @param testMode
	 */
	public MDCheckRsyncCoda(Runnable target, String name, boolean testMode) {
		super(target, name, testMode);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see it.bncf.magazziniDigitali.client.thread.MDCheck#analize(java.io.File)
	 */
	@Override
	protected boolean analize(File fileTarGz) throws NoSuchAlgorithmException,
			FileNotFoundException, IOException, ClientMDException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see it.bncf.magazziniDigitali.client.thread.MDCheck#isSender()
	 */
	@Override
	protected boolean isSender() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected File genFileTarGz(File pathDescriptati, String fileName) {
		File file = null;
		
//		File
		// TODO Auto-generated method stub
		return null;
	}

}
