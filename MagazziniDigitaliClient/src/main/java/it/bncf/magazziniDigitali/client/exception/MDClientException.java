/**
 * 
 */
package it.bncf.magazziniDigitali.client.exception;

/**
 * @author massi
 *
 */
public class MDClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6954510449357578500L;

	/**
	 * @param arg0
	 */
	public MDClientException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public MDClientException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
