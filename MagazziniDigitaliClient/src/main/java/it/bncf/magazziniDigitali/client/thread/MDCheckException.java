/**
 * 
 */
package it.bncf.magazziniDigitali.client.thread;

/**
 * @author massi
 *
 */
public class MDCheckException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4175210413040093586L;

	/**
	 * @param message
	 */
	public MDCheckException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MDCheckException(String message, Throwable cause) {
		super(message, cause);
	}

}
