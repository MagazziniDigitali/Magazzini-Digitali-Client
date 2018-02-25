/**
 * 
 */
package it.depositolegale.www.test.software;

import it.depositolegale.www.software.Software;
import it.depositolegale.www.software.SoftwareAuthentication;
import it.depositolegale.www.software.SoftwareConfig;
import it.depositolegale.www.software.SoftwareConfigNodo;
import it.depositolegale.www.software.SoftwareIstituzione;
import it.depositolegale.www.software.SoftwareIstituzioneApiUtente;
import it.depositolegale.www.test.errorMsg.PrintErrorMsg;

/**
 * @author massi
 *
 */
public class PrintSoftware extends PrintErrorMsg {

	/**
	 * 
	 */
	public PrintSoftware() {
	}

	protected void print(Software software){
		String prefix = "";

		print(software.getAuthentication(),prefix); 
		print(software.getErrorMsg(),prefix); 
		print("ID", software.getId(),prefix); 
		print("Nome",software.getNome(),prefix); 
		print(software.getIstituzione(),prefix); 
		print(software.getSoftwareConfig(),prefix);

	}

	protected void print(SoftwareAuthentication authentication, String prefix) {
		if (authentication != null){
			System.out.println(prefix+"Authentication:");
			prefix +="\t";
			System.out.println(prefix+"Login: "+authentication.getLogin());
			System.out.println(prefix+"Password: "+authentication.getPassword());
		}
	}

	protected void print(SoftwareConfig[] softwareConfig, String prefix) {
		if (softwareConfig != null && softwareConfig.length>0){
			System.out.println(prefix+"SoftwareConfig");
			prefix +="\t";
			for (int x=0; x<softwareConfig.length;x++){
				if (x>0){
					System.out.println(prefix+"--------------------------------");
				}
				print(softwareConfig[x], prefix);
			}
		}
	}

	private void print(SoftwareConfig softwareConfig, String prefix) {
		if (softwareConfig != null) {
			System.out.println(prefix + "SoftwareConfig");
			prefix += "\t";
			print("ID", softwareConfig.getId(), prefix);
			print("Nome", softwareConfig.getNome(), prefix);
			print("Descrizione", softwareConfig.getDescrizione(), prefix);
			print("Value", softwareConfig.getValue(), prefix);
			print(softwareConfig.getNodo(), prefix);
		}
	}

	private void print(SoftwareConfigNodo nodo, String prefix) {
		if (nodo != null) {
			System.out.println(prefix + "SoftwareConfigNodo");
			prefix += "\t";
			print("ID", nodo.getId(), prefix);
			print("Nome", nodo.getNome(), prefix);
			print("Descrizioni", nodo.getDescrizioni(), prefix);
//			print(nodo.getRsync(), prefix);
//			print("UrlCheckStorage", nodo.getUrlCheckStorage(), prefix);
		}
	}
//
//	private void print(SoftwareConfigNodoRsync rsync, String prefix) {
//		if (rsync != null) {
//			System.out.println(prefix + "SoftwareConfigNodoRsync");
//			prefix += "\t";
//			print("Indirizzo", rsync.getIndirizzo(), prefix);
//			print("Password", rsync.getPassword(), prefix);
//		}
//	}

	protected void print(SoftwareIstituzione istituzione, String prefix) {
		if (istituzione != null) {
			System.out.println(prefix + "Istituzione");
			prefix += "\t";
			print("ID", istituzione.getId(), prefix);
			print("Nome", istituzione.getNome(), prefix);
			print("Indirizzo", istituzione.getIndirizzo(), prefix);
			print("Telefono", istituzione.getTelefono(), prefix);
			print("NomeContatto", istituzione.getNomeContatto(), prefix);
			print("BibliotecaDepositaria", istituzione.getBibliotecaDepositaria(), prefix);
			print("IstitutoCentrale", istituzione.getIstitutoCentrale(), prefix);
			print("IpAccreditati", istituzione.getIpAccreditati(), prefix);
			print(istituzione.getApiUtente(), prefix);
			print("EmailBagit", istituzione.getEmailBagit(), prefix);
		}
	}

	private void print(SoftwareIstituzioneApiUtente apiUtente, String prefix) {
		if (apiUtente != null) {
			System.out.println(prefix + "Api Utente");
			prefix += "\t";
			print("Interfaccia", apiUtente.getInterfaccia(), prefix);
			print("Libreria", apiUtente.getLibreria(), prefix);
		}
	}

}
