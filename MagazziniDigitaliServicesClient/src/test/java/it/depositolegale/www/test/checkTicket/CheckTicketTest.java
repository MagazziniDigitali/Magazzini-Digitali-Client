/**
 * 
 */
package it.depositolegale.www.test.checkTicket;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import org.apache.axis.types.URI;

import it.depositolegale.www.checkTicket.CheckTicket;
import it.depositolegale.www.checkTicket.CheckTicketSoftware;
import it.depositolegale.www.checkTicket.CheckTicketSoftwareAuthentication;
import it.depositolegale.www.checkTicket.CheckTicketSoftwareIstituzione;
import it.depositolegale.www.checkTicket.CheckTicketSoftwareIstituzioneApiUtente;
import it.depositolegale.www.checkTicket.CheckTicketSoftwareRigth;
import it.depositolegale.www.checkTicketOutput.CheckTicketOutput;
import it.depositolegale.www.checkTicketOutput.CheckTicketOutputCheckTicket;
import it.depositolegale.www.checkTicketOutput.CheckTicketOutputCheckTicketSoftware;
import it.depositolegale.www.checkTicketOutput.CheckTicketOutputCheckTicketSoftwareAuthentication;
import it.depositolegale.www.checkTicketOutput.CheckTicketOutputCheckTicketSoftwareIstituzione;
import it.depositolegale.www.checkTicketOutput.CheckTicketOutputCheckTicketSoftwareIstituzioneApiUtente;
import it.depositolegale.www.checkTicketOutput.CheckTicketOutputCheckTicketSoftwareRigth;
import it.depositolegale.www.errorMsg.ErrorMsg;
import it.depositolegale.www.rigths.RightType_type;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.software.SoftwareConfig;
import it.depositolegale.www.test.authenticationSoftware.AuthenticationSoftwareImplement;
import it.depositolegale.www.webservice_checkTicket.CheckTicketPortTypeProxy;

/**
 * @author massi
 *
 */
public class CheckTicketTest 
		extends AuthenticationSoftwareImplement<CheckTicketSoftware, 
						CheckTicketSoftwareAuthentication, CheckTicketSoftwareIstituzione,
						CheckTicketSoftwareIstituzioneApiUtente,
						CheckTicketSoftwareRigth>{

	/**
	 * 
	 */
	public CheckTicketTest() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckTicketTest writeEventNBNTest = null;

		if (args.length == 3) {
			writeEventNBNTest = new CheckTicketTest();
			writeEventNBNTest.esegui(args[0], args[1], args[2]);
		} else {
			System.out.println("Indicare i seguenti parametri:");
			System.out.println("1) L'indirizzo del server da contattare");
			System.out.println("2) Ticket richiesta");
			System.out.println("3) ip Client");
		}
	}

	public void esegui(String host, String ticket, String idClient) {
		CheckTicketPortTypeProxy proxy = null;
		CheckTicketOutput output = null;
		String url = null;
		Software software = null;

		try {
			software = chiama(host, "DOCKER_MD", "m@9@221n1");
			if (software != null && (software.getErrorMsg() == null || software.getErrorMsg().length==0)){
				url = readParam(software.getSoftwareConfig(),"CheckTicketPort");
				System.out.println("URL: "+url);
				//"http://" + host + "/MagazziniDigitaliServices/services/WriteEventNBNPort?wsdl";
	
				proxy = new CheckTicketPortTypeProxy(url);
	
				output = proxy.checkTicketOperation(genCheckTicketOperation(software, ticket,  idClient));
	
				print(output);
			} else {
				print(software);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private void print(CheckTicketOutput output) {
		
		print(output.getCheckTicket(),"");
		if (output.getTipo() != null){
			print("Tipo", output.getTipo().getValue(), "");
		}
		print("URL", output.getUrl(), "");
		print(output.getErrorMsg(),"");
	}

	private void print(CheckTicketOutputCheckTicket checkTicket, String prefix) {
		if (checkTicket != null) {
			System.out.println(prefix + "Check Ticket");
			prefix += "\t";
		
			print(checkTicket.getSoftware(),prefix);
			print("Ticket ", checkTicket.getTicket(), prefix);
			print("ID Client ", checkTicket.getIpClient(), prefix);
		}
	}

	private void print(CheckTicketOutputCheckTicketSoftware software, String prefix) {
		if (software != null) {
			System.out.println(prefix + "UserInputSoftware");
			prefix += "\t";
			print(software.getAuthentication(), prefix);
			print(software.getErrorMsg(), prefix);
			print("ID", software.getId(), prefix);
			print("Nome", software.getNome(), prefix);
			print(software.getIstituzione(), prefix);
			print(software.getRigth(), prefix);
			print(software.getSoftwareConfig(), prefix);
		}
	}

	private void print(CheckTicketOutputCheckTicketSoftwareRigth rigth, String prefix) {
		if (rigth != null) {
			System.out.println(prefix + "UserInputSoftwareRigth");
			prefix += "\t";
			print("ID", rigth.getId(), prefix);
			print("Nome", rigth.getNome(), prefix);
			print("Type", rigth.getType().getValue(), prefix);
		}
	}

	private void print(CheckTicketOutputCheckTicketSoftwareIstituzione istituzione, String prefix) {
		if (istituzione != null) {
			System.out.println(prefix + "UserInputSoftwareIstituzione");
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

	private void print(CheckTicketOutputCheckTicketSoftwareIstituzioneApiUtente apiUtente, String prefix) {
		if (apiUtente != null) {
			System.out.println(prefix + "UserInputSoftwareIstituzioneApiUtente");
			prefix += "\t";
			print("Interfaccia", apiUtente.getInterfaccia(), prefix);
			print("Libreria", apiUtente.getLibreria(), prefix);
		}
	}

	private void print(CheckTicketOutputCheckTicketSoftwareAuthentication authentication, String prefix) {
		if (authentication != null) {
			System.out.println(prefix + "UserInputSoftwareAuthentication");
			prefix += "\t";
			print("Login", authentication.getLogin(), prefix);
			print("Password", authentication.getPassword(), prefix);
		}
	}

	private CheckTicket genCheckTicketOperation(Software software, String ticket, String idClient) {
		CheckTicket input = null;

		input = new CheckTicket();
		input.setSoftware(convertSoftware(software));
		input.setTicket(ticket);
		input.setIpClient(idClient);
		return input;
	}

	@Override
	protected CheckTicketSoftware initSoftware(CheckTicketSoftwareAuthentication a, ErrorMsg[] errorMsgs, String id,
			String nome, CheckTicketSoftwareIstituzione istituzione, CheckTicketSoftwareRigth softwareRigth,
			SoftwareConfig[] softwareConfigs) {
		return new CheckTicketSoftware(a, errorMsgs, id, nome, istituzione, softwareRigth, 
				softwareConfigs);
	}

	@Override
	protected CheckTicketSoftwareAuthentication initAuthentication(String login, String password) {
		return new CheckTicketSoftwareAuthentication(login, password);
	}

	@Override
	protected CheckTicketSoftwareIstituzione initIstituzione(String id, String nome, String indirizzo,
	           String telefono, String nomeContatto, BigInteger bibliotecaDepositaria, BigInteger istitutoCentrale,
	           String[] ipAccreditati, CheckTicketSoftwareIstituzioneApiUtente apiUtente, String emailBagit) {
		return new CheckTicketSoftwareIstituzione(id, nome, indirizzo, telefono, nomeContatto, bibliotecaDepositaria, istitutoCentrale, ipAccreditati, apiUtente, emailBagit);
	}

	@Override
	protected CheckTicketSoftwareIstituzioneApiUtente initApiUtente(URI interfaccia, String libreria) {
		return new  CheckTicketSoftwareIstituzioneApiUtente(interfaccia, libreria);
	}

	@Override
	protected CheckTicketSoftwareRigth initRigth(String id, String nome, RightType_type type) {
		return new CheckTicketSoftwareRigth(id, nome, type);
	}

}
