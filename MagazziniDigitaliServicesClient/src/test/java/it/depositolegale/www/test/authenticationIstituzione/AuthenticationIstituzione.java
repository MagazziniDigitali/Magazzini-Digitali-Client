/**
 * 
 */
package it.depositolegale.www.test.authenticationIstituzione;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import it.depositolegale.www.istituzione.MdIstituzione;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiAuthentication;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftware;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftwareAuthentication;
import it.depositolegale.www.webservice_authenticationIstituzione.AuthenticationIstituzionePortTypeProxy;
import mx.randalf.tools.SHA256Tools;

/**
 * @author massi
 *
 */
public class AuthenticationIstituzione {

	/**
	 * 
	 */
	public AuthenticationIstituzione() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthenticationIstituzionePortTypeProxy proxy = null;
		it.depositolegale.www.loginUtenti.AuthenticationUtenti authenticationUtenti = null;
		AuthenticationUtentiAuthentication authentication = null;
		AuthenticationUtentiSoftware software = null;
		AuthenticationUtentiSoftwareAuthentication softwareAuthentication = new AuthenticationUtentiSoftwareAuthentication();
		SHA256Tools sha256Tools = null;
		MdIstituzione utenti = null;
		String url = null;
		
		if (args.length==3){
			try {
				url = "http://"+args[0]+"/MagazziniDigitaliServices/services/AuthenticationIstituzionePort?wsdl";
				proxy = new AuthenticationIstituzionePortTypeProxy(url);

				authenticationUtenti = new it.depositolegale.www.loginUtenti.AuthenticationUtenti();
				
				authentication = new AuthenticationUtentiAuthentication();
				authentication.setLogin(args[1]);

				sha256Tools = new SHA256Tools();
				authentication.setPassword(sha256Tools.checkSum(args[2].getBytes()));

				authenticationUtenti.setAuthentication(authentication);

				software = new AuthenticationUtentiSoftware();
				softwareAuthentication = new AuthenticationUtentiSoftwareAuthentication("GS_MD",sha256Tools.checkSum("m@9@221n1".getBytes()));
				software.setAuthentication(softwareAuthentication);
				software.setId("51557609-f3b5-4cd9-9210-62ef51177536");
				
				authenticationUtenti.setSoftware(software);
				utenti = proxy.authenticationIstituzioneOperation(authenticationUtenti);

				if (utenti != null){
					System.out.println("Authentication:");
					System.out.println("\tLogin: "+utenti.getAuthenticationUtenti().getAuthentication().getLogin());
					System.out.println("\tPassword: "+utenti.getAuthenticationUtenti().getAuthentication().getPassword());
					if (utenti.getErrorMsg()!= null && utenti.getErrorMsg().length>0){
						for (int x=0; x<utenti.getErrorMsg().length; x++){
							System.out.println(utenti.getErrorMsg()[x].getErrorType().getValue()+" -> "+utenti.getErrorMsg()[x].getMsgError());
						}
					} else {
						System.out.println("Istituzione:");
						System.out.println("\tID: "+utenti.getIstituzione().getId());
						System.out.println("\tNome: "+utenti.getIstituzione().getNome());
						System.out.println("\tIndirizzo: "+utenti.getIstituzione().getIndirizzo());
						System.out.println("\tTelefono: "+utenti.getIstituzione().getTelefono());
						System.out.println("\tNome Contatto: "+utenti.getIstituzione().getNomeContatto());
						System.out.println("\tBiblioteca Depositaria: "+utenti.getIstituzione().getBibliotecaDepositaria());
						System.out.println("\tIstituto Centrale: "+utenti.getIstituzione().getIstitutoCentrale());
						System.out.println("\tIp Accreditati: ");
						if (utenti.getIstituzione().getIpAccreditati() != null){
							for (int x=0; x<utenti.getIstituzione().getIpAccreditati().length; x++){
								System.out.println("\t\t "+utenti.getIstituzione().getIpAccreditati()[x]);
							}
						}
						System.out.println("\tApi Utente: ");
						if (utenti.getIstituzione().getApiUtente() != null){
							System.out.println("\t\tInterfaccia: "+utenti.getIstituzione().getApiUtente().getInterfaccia());
							System.out.println("\t\tLibreria: "+utenti.getIstituzione().getApiUtente().getLibreria());
						}
						System.out.println("\tEmail Bagit: "+utenti.getIstituzione().getEmailBagit());
					}
				} else {
					System.err.println("La risposta è NULL");
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		
		} else {
			System.out.println("Indicare i seguenti parametri:");
			System.out.println("1) L'indirizzo del server da contattare");
			System.out.println("2) Login del Software");
			System.out.println("3) La password del Software");
		}
	}

}
