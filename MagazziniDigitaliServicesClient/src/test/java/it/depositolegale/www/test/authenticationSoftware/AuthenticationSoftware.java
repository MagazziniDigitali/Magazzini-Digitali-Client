/**
 * 
 */
package it.depositolegale.www.test.authenticationSoftware;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import it.depositolegale.www.login.Authentication;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.webservice_authenticationSoftware.AuthenticationSoftwarePortTypeProxy;
import mx.randalf.tools.SHA256Tools;

/**
 * @author massi
 *
 */
public class AuthenticationSoftware {

	/**
	 * 
	 */
	public AuthenticationSoftware() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthenticationSoftwarePortTypeProxy proxy = null;
		Authentication authentication = null;
		SHA256Tools sha256Tools = null;
		Software software = null;
		String url = null;
		
		if (args.length==3){
			try {
				url = "http://"+args[0]+"/MagazziniDigitaliServices/services/AuthenticationSoftwarePort?wsdl";
				proxy = new AuthenticationSoftwarePortTypeProxy(url);

				authentication = new Authentication();
				authentication.setLogin(args[1]);
				sha256Tools = new SHA256Tools();
				authentication.setPassword(sha256Tools.checkSum(args[2].getBytes()));
				software = proxy.authenticationSoftwareOperation(authentication);
				if (software != null){
					System.out.println("Authentication:");
					System.out.println("\tLogin: "+software.getAuthentication().getLogin());
					System.out.println("\tPassword: "+software.getAuthentication().getPassword());
					if (software.getErrorMsg()!= null && software.getErrorMsg().length>0){
						for (int x=0; x<software.getErrorMsg().length; x++){
							System.err.println(software.getErrorMsg()[x].getErrorType().getValue()+" -> "+software.getErrorMsg()[x].getMsgError());
						}
					} else {
						System.out.println("ID: "+software.getId());
						System.out.println("Nome: "+software.getNome());
						System.out.println("Istituzione:");
						System.out.println("\tID: "+software.getIstituzione().getId());
						System.out.println("\tNome: "+software.getIstituzione().getNome());
						System.out.println("\tIndirizzo: "+software.getIstituzione().getIndirizzo());
						System.out.println("\tTelefono: "+software.getIstituzione().getTelefono());
						System.out.println("\tNome Contatto: "+software.getIstituzione().getNomeContatto());
						System.out.println("\tBiblioteca Depositaria: "+software.getIstituzione().getBibliotecaDepositaria());
						System.out.println("\tIstituto Centrale: "+software.getIstituzione().getIstitutoCentrale());
						System.out.println("\tIp Accreditati: ");
						if (software.getIstituzione().getIpAccreditati() != null){
							for (int x=0; x<software.getIstituzione().getIpAccreditati().length; x++){
								System.out.println("\t\t "+software.getIstituzione().getIpAccreditati()[x]);
							}
						}
						System.out.println("\tApi Utente: ");
						if (software.getIstituzione().getApiUtente() != null){
							System.out.println("\t\tInterfaccia: "+software.getIstituzione().getApiUtente().getInterfaccia());
							System.out.println("\t\tLibreria: "+software.getIstituzione().getApiUtente().getLibreria());
						}
						System.out.println("\tEmail Bagit: "+software.getIstituzione().getEmailBagit());
						if (software.getSoftwareConfig() != null){
							for (int x=0; x<software.getSoftwareConfig().length; x++){
								System.out.println("Software Config:");
								System.out.println("\tID: "+software.getSoftwareConfig()[x].getId());
								System.out.println("\tNome: "+software.getSoftwareConfig()[x].getNome());
								System.out.println("\tDescrizione: "+software.getSoftwareConfig()[x].getDescrizione());
								if (software.getSoftwareConfig()[x].getValue()!= null){
									System.out.println("\tValue: "+software.getSoftwareConfig()[x].getValue());
								} else if (software.getSoftwareConfig()[x].getNodo()!= null){
									System.out.println("\tNodo: ");
									System.out.println("\t\tID: "+software.getSoftwareConfig()[x].getNodo().getId());
									System.out.println("\t\tNome: "+software.getSoftwareConfig()[x].getNodo().getNome());
									System.out.println("\t\tDescrizione: "+software.getSoftwareConfig()[x].getNodo().getDescrizioni());
									System.out.println("\t\tRsync: ");
									System.out.println("\t\t\tID: "+software.getSoftwareConfig()[x].getNodo().getRsync().getIndirizzo());
									System.out.println("\t\t\tPassword: "+software.getSoftwareConfig()[x].getNodo().getRsync().getPassword());
									System.out.println("\t\tUrl Check Storage: "+software.getSoftwareConfig()[x].getNodo().getUrlCheckStorage());
								}
							}
						}
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
