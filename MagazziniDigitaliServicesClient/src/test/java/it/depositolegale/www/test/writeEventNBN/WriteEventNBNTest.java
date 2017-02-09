/**
 * 
 */
package it.depositolegale.www.test.writeEventNBN;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.axis.types.URI;

import it.depositolegale.www.errorMsg.ErrorMsg;
import it.depositolegale.www.rigths.RightType_type;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.software.SoftwareConfig;
import it.depositolegale.www.test.authenticationSoftware.AuthenticationSoftwareImplement;
import it.depositolegale.www.webservice_writeEventNBN.WriteEventNBNPortTypeProxy;
import it.depositolegale.www.writeEventNBN.WriteEventNBN;
import it.depositolegale.www.writeEventNBN.WriteEventNBNSoftware;
import it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareAuthentication;
import it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareIstituzione;
import it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareIstituzioneApiUtente;
import it.depositolegale.www.writeEventNBN.WriteEventNBNSoftwareRigth;
import it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutput;
import it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBN;
import it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftware;
import it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftwareAuthentication;
import it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftwareIstituzione;
import it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftwareIstituzioneApiUtente;
import it.depositolegale.www.writeEventNBNOutput.WriteEventNBNOutputWriteEventNBNSoftwareRigth;

/**
 * @author massi
 *
 */
public class WriteEventNBNTest 
		extends AuthenticationSoftwareImplement<WriteEventNBNSoftware, 
					WriteEventNBNSoftwareAuthentication, WriteEventNBNSoftwareIstituzione,
					WriteEventNBNSoftwareIstituzioneApiUtente,
					WriteEventNBNSoftwareRigth>{

	/**
	 * 
	 */
	public WriteEventNBNTest() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WriteEventNBNTest writeEventNBNTest = null;
		GregorianCalendar dataInizioElab = null;
		String data = "";
		String ora = null;
		String[] st = null;
		String[] st2 = null;

		if (args.length == 3 || args.length == 4) {
			writeEventNBNTest = new WriteEventNBNTest();
			if (args.length==4){
				st =args[3].split(" ");
				data = st[0];
				if (st.length>1){
					ora = st[1];
				}
				dataInizioElab = new GregorianCalendar();
				st = data.split("/");
				if (ora != null){
					st2 = ora.split(":");
					dataInizioElab.set(Integer.parseInt(st[2]), Integer.parseInt(st[1])-1, Integer.parseInt(st[0]),
							Integer.parseInt(st2[0]), Integer.parseInt(st2[1])-1, Integer.parseInt(st2[2]));
				} else {
					dataInizioElab.set(Integer.parseInt(st[2]), Integer.parseInt(st[1])-1, Integer.parseInt(st[0]));
				}
			}
			writeEventNBNTest.esegui(args[0], args[1], args[2], dataInizioElab);
		} else {
			System.out.println("Indicare i seguenti parametri:");
			System.out.println("1) L'indirizzo del server da contattare");
			System.out.println("2) Codice NBN");
			System.out.println("3) URL Originale");
			System.out.println("4) Data e ora inizio Elaborazione (Opzionale)");
		}
	}

	public void esegui(String host, String codiceNBN, String urlOriginale, Calendar dataInizioElab) {
		WriteEventNBNPortTypeProxy proxy = null;
		WriteEventNBNOutput output = null;
		String url = null;
		Software software = null;

		try {
			software = chiama(host, "NBN_MD", "m@9@221n1");
			if (software != null && (software.getErrorMsg() == null || software.getErrorMsg().length==0)){
				url = readParam(software.getSoftwareConfig(),"WriteEventNBNPort");
				//"http://" + host + "/MagazziniDigitaliServices/services/WriteEventNBNPort?wsdl";
	
				proxy = new WriteEventNBNPortTypeProxy(url);
	
				output = proxy.writeEventNBNOperation(genWriteEventNBNOperation(software, codiceNBN,  urlOriginale,
						 dataInizioElab));
	
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

	private void print(WriteEventNBNOutput output) {
		print(output.getWriteEventNBN(),"");
		print("Esito ", output.getEsito().getValue(), "");
		print(output.getErrorMsg(),"");
	}

	private void print(WriteEventNBNOutputWriteEventNBN output, String prefix) {
		if (output != null) {
			System.out.println(prefix + "WriteEventNBN");
			prefix += "\t";
			print(output.getSoftware(), prefix);
			print("CodiceNBN ", output.getCodiceNBN(), "");
			print("UrlOriginale ", output.getUrlOriginale(), "");
			print("DataInizioElab ", output.getDataInizioElab(), "");
		}
	}

	private void print(WriteEventNBNOutputWriteEventNBNSoftware software, String prefix) {
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

	private void print(WriteEventNBNOutputWriteEventNBNSoftwareRigth rigth, String prefix) {
		if (rigth != null) {
			System.out.println(prefix + "UserInputSoftwareRigth");
			prefix += "\t";
			print("ID", rigth.getId(), prefix);
			print("Nome", rigth.getNome(), prefix);
			print("Type", rigth.getType().getValue(), prefix);
		}
	}

	private void print(WriteEventNBNOutputWriteEventNBNSoftwareIstituzione istituzione, String prefix) {
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

	private void print(WriteEventNBNOutputWriteEventNBNSoftwareIstituzioneApiUtente apiUtente, String prefix) {
		if (apiUtente != null) {
			System.out.println(prefix + "UserInputSoftwareIstituzioneApiUtente");
			prefix += "\t";
			print("Interfaccia", apiUtente.getInterfaccia(), prefix);
			print("Libreria", apiUtente.getLibreria(), prefix);
		}
	}

	private void print(WriteEventNBNOutputWriteEventNBNSoftwareAuthentication authentication, String prefix) {
		if (authentication != null) {
			System.out.println(prefix + "UserInputSoftwareAuthentication");
			prefix += "\t";
			print("Login", authentication.getLogin(), prefix);
			print("Password", authentication.getPassword(), prefix);
		}
	}

	private WriteEventNBN genWriteEventNBNOperation(Software software, String codiceNBN, String urlOriginale,
			Calendar dataInizioElab) {
		WriteEventNBN input = null;

		input = new WriteEventNBN();
		input.setSoftware(convertSoftware(software));
		input.setCodiceNBN(codiceNBN);
		input.setUrlOriginale(urlOriginale);
		if (dataInizioElab!= null){
			input.setDataInizioElab(dataInizioElab);
		}
		return input;
	}

	@Override
	protected WriteEventNBNSoftware initSoftware(WriteEventNBNSoftwareAuthentication a, ErrorMsg[] errorMsgs, String id,
			String nome, WriteEventNBNSoftwareIstituzione istituzione, WriteEventNBNSoftwareRigth softwareRigth,
			SoftwareConfig[] softwareConfigs) {
		return new WriteEventNBNSoftware(a, errorMsgs, id, nome, istituzione, softwareRigth, 
				softwareConfigs);
	}

	@Override
	protected WriteEventNBNSoftwareAuthentication initAuthentication(String login, String password) {
		return new WriteEventNBNSoftwareAuthentication(login, password);
	}

	@Override
	protected WriteEventNBNSoftwareIstituzione initIstituzione(String id, String nome, String indirizzo,
	           String telefono, String nomeContatto, BigInteger bibliotecaDepositaria, BigInteger istitutoCentrale,
	           String[] ipAccreditati, WriteEventNBNSoftwareIstituzioneApiUtente apiUtente, String emailBagit) {
		return new WriteEventNBNSoftwareIstituzione(id, nome, indirizzo, telefono, nomeContatto, bibliotecaDepositaria, istitutoCentrale, ipAccreditati, apiUtente, emailBagit);
	}

	@Override
	protected WriteEventNBNSoftwareIstituzioneApiUtente initApiUtente(URI interfaccia, String libreria) {
		return new  WriteEventNBNSoftwareIstituzioneApiUtente(interfaccia, libreria);
	}

	@Override
	protected WriteEventNBNSoftwareRigth initRigth(String id, String nome, RightType_type type) {
		return new WriteEventNBNSoftwareRigth(id, nome, type);
	}

}
