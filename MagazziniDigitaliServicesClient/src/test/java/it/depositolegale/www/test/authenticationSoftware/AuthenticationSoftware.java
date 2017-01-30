/**
 * 
 */
package it.depositolegale.www.test.authenticationSoftware;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import it.depositolegale.www.login.Authentication;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.test.software.PrintSoftware;
import it.depositolegale.www.webservice_authenticationSoftware.AuthenticationSoftwarePortTypeProxy;
import mx.randalf.tools.SHA256Tools;

/**
 * @author massi
 *
 */
public class AuthenticationSoftware extends PrintSoftware {

	/**
	 * 
	 */
	public AuthenticationSoftware() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthenticationSoftware authenticationSoftware = null;
		
		try {
			if (args.length==3){
				authenticationSoftware = new AuthenticationSoftware();
				authenticationSoftware.esegui(args[0], args[1], args[2]);
			} else {
				System.out.println("Indicare i seguenti parametri:");
				System.out.println("1) L'indirizzo del server da contattare");
				System.out.println("2) Login del Software");
				System.out.println("3) La password del Software");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void esegui(String host, String login, String password) throws NoSuchAlgorithmException, RemoteException{
		Software software = null;
		try {
			software = chiama(host, login, password);
			if (software != null){
				print(software);
			} else {
				System.err.println("La risposta è NULL");
			}
		} catch (NoSuchAlgorithmException e) {
			throw e;
		} catch (RemoteException e) {
			throw e;
		}

	}

	protected Software chiama(String host, String login, String password) throws NoSuchAlgorithmException, RemoteException{
		String url = null;
		AuthenticationSoftwarePortTypeProxy proxy = null;
		Authentication authentication = null;
		SHA256Tools sha256Tools = null;
		Software software = null;

		try {
			url = "http://"+host+"/MagazziniDigitaliServices/services/AuthenticationSoftwarePort?wsdl";
			System.out.println("URL: "+url);
			proxy = new AuthenticationSoftwarePortTypeProxy(url);

			authentication = new Authentication();
			authentication.setLogin(login);
			sha256Tools = new SHA256Tools();
			authentication.setPassword(sha256Tools.checkSum(password.getBytes()));
			software = proxy.authenticationSoftwareOperation(authentication);
		} catch (NoSuchAlgorithmException e) {
			throw e;
		} catch (RemoteException e) {
			throw e;
		}
		return software;
	}
}
