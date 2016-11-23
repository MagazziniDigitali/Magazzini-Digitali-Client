/**
 * 
 */
package it.depositolegale.www.test.authenticationUtenti;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import it.depositolegale.www.loginUtenti.AuthenticationUtentiAuthentication;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftware;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftwareAuthentication;
import it.depositolegale.www.utenti.Utenti;
import it.depositolegale.www.webservice_authenticationUtenti.AuthenticationUtentiPortTypeProxy;
import mx.randalf.tools.SHA256Tools;

/**
 * @author massi
 *
 */
public class AuthenticationUtenti {

	/**
	 * 
	 */
	public AuthenticationUtenti() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthenticationUtentiPortTypeProxy proxy = null;
		it.depositolegale.www.loginUtenti.AuthenticationUtenti authenticationUtenti = null;
		AuthenticationUtentiAuthentication authentication = null;
		AuthenticationUtentiSoftware software = null;
		AuthenticationUtentiSoftwareAuthentication softwareAuthentication = new AuthenticationUtentiSoftwareAuthentication();
		SHA256Tools sha256Tools = null;
		Utenti utenti = null;
		String url = null;
		
		if (args.length==3){
			try {
				url = "http://"+args[0]+"/MagazziniDigitaliServices/services/AuthenticationUtentiPort?wsdl";
				proxy = new AuthenticationUtentiPortTypeProxy(url);

				authenticationUtenti = new it.depositolegale.www.loginUtenti.AuthenticationUtenti();
				
				authentication = new AuthenticationUtentiAuthentication();
				authentication.setLogin(args[1]);

				sha256Tools = new SHA256Tools();
				authentication.setPassword(sha256Tools.checkSum(args[2].getBytes()));

				authenticationUtenti.setAuthentication(authentication);
				authenticationUtenti.setIpClient("127.0.0.1");

				software = new AuthenticationUtentiSoftware();
				softwareAuthentication = new AuthenticationUtentiSoftwareAuthentication("GS_MD",sha256Tools.checkSum("m@9@221n1".getBytes()));
				software.setAuthentication(softwareAuthentication);
				software.setId("51557609-f3b5-4cd9-9210-62ef51177536");
				
				authenticationUtenti.setSoftware(software);
				utenti = proxy.authenticationUtentiOperation(authenticationUtenti);

				if (utenti != null){
					System.out.println("Authentication:");
					System.out.println("\tLogin: "+utenti.getAuthenticationUtenti().getAuthentication().getLogin());
					System.out.println("\tPassword: "+utenti.getAuthenticationUtenti().getAuthentication().getPassword());
					if (utenti.getErrorMsg()!= null && utenti.getErrorMsg().length>0){
						for (int x=0; x<utenti.getErrorMsg().length; x++){
							System.err.println(utenti.getErrorMsg()[x].getErrorType().getValue()+" -> "+utenti.getErrorMsg()[x].getMsgError());
						}
					} else {
						System.out.println("ID: "+utenti.getDatiUtente().getId());
						System.out.println("Cognome: "+utenti.getDatiUtente().getCognome());
						System.out.println("Nome: "+utenti.getDatiUtente().getNome());
						System.out.println("Amministratore: "+utenti.getDatiUtente().getAmministratore());
						System.out.println("IP Accreditati: "+utenti.getDatiUtente().getIpAccreditati());
						System.out.println("Istituzione:");
						System.out.println("\tID: "+utenti.getDatiUtente().getIstituzione().getId());
						System.out.println("\tNome: "+utenti.getDatiUtente().getIstituzione().getNome());
						System.out.println("\tIndirizzo: "+utenti.getDatiUtente().getIstituzione().getIndirizzo());
						System.out.println("\tTelefono: "+utenti.getDatiUtente().getIstituzione().getTelefono());
						System.out.println("\tNome Contatto: "+utenti.getDatiUtente().getIstituzione().getNomeContatto());
						System.out.println("\tBiblioteca Depositaria: "+utenti.getDatiUtente().getIstituzione().getBibliotecaDepositaria());
						System.out.println("\tIstituto Centrale: "+utenti.getDatiUtente().getIstituzione().getIstitutoCentrale());
						System.out.println("\tIp Accreditati: ");
						if (utenti.getDatiUtente().getIstituzione().getIpAccreditati() != null){
							for (int x=0; x<utenti.getDatiUtente().getIstituzione().getIpAccreditati().length; x++){
								System.out.println("\t\t "+utenti.getDatiUtente().getIstituzione().getIpAccreditati()[x]);
							}
						}
						System.out.println("\tApi Utente: ");
						if (utenti.getDatiUtente().getIstituzione().getApiUtente() != null){
							System.out.println("\t\tInterfaccia: "+utenti.getDatiUtente().getIstituzione().getApiUtente().getInterfaccia());
							System.out.println("\t\tLibreria: "+utenti.getDatiUtente().getIstituzione().getApiUtente().getLibreria());
						}
						System.out.println("\tEmail Bagit: "+utenti.getDatiUtente().getIstituzione().getEmailBagit());
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
