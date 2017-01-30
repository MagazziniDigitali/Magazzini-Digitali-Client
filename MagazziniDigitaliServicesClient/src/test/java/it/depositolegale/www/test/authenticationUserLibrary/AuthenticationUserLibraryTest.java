/**
 * 
 */
package it.depositolegale.www.test.authenticationUserLibrary;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import it.depositolegale.www.authenticationUserInput.AuthenticationUserInput;
import it.depositolegale.www.authenticationUserInput.UserInput;
import it.depositolegale.www.authenticationUserInput.UserInputAgent;
import it.depositolegale.www.authenticationUserInput.UserInputAuthentication;
import it.depositolegale.www.authenticationUserInput.UserInputObjectIdentifier;
import it.depositolegale.www.authenticationUserInput.UserInputRights;
import it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminate;
import it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminateRightsDisseminateType;
import it.depositolegale.www.authenticationUserInput.UserInputRightsRightsIdentifier;
import it.depositolegale.www.authenticationUserInput.UserInputSoftware;
import it.depositolegale.www.authenticationUserInput.UserInputSoftwareAuthentication;
import it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput;
import it.depositolegale.www.webservice_authenticationUserLibrary.AuthenticationUserLibraryPortTypeProxy;
import mx.randalf.tools.SHA256Tools;

/**
 * @author massi
 *
 */
public class AuthenticationUserLibraryTest extends PrintAuthenticationUserOutput {

	/**
	 * 
	 */
	public AuthenticationUserLibraryTest() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthenticationUserLibraryTest authenticationUserLibraryTest = null;

		if (args.length == 4 || args.length == 14) {
			authenticationUserLibraryTest = new AuthenticationUserLibraryTest();
			if (args.length == 4) {
				authenticationUserLibraryTest.esegui(args[0], args[1], args[2], args[3]);
			} else {
				authenticationUserLibraryTest.esegui(args[0], args[1], args[2], args[3], args[4], args[5], args[6],
						args[7], args[8], args[9], args[10], args[11], args[12], args[13]);
			}
		} else {
			System.out.println("Indicare i seguenti parametri:");
			System.out.println("1) L'indirizzo del server da contattare");
			System.out.println("2) Tipo Identificativo");
			System.out.println("3) Valore Identificativo");
			System.out.println("4) ipClient");
			System.out.println("5) Identifier");
			System.out.println("6) ActualFileName");
			System.out.println("7) OriginalFileName");
			System.out.println("8) AgentIdentifier");
			System.out.println("9) AgentName");
			System.out.println("10) RightsIdentifierType");
			System.out.println("11) RightsIdentifierValue");
			System.out.println("12) RightsDisseminateType");
			System.out.println("13) LoginUtente");
			System.out.println("14) PasswordUtente");
		}
	}

	public void esegui(String host, String identifierType, String identifierValue, String ipClient) {
		esegui(host, identifierType, identifierValue, ipClient, null, null, null, null, null, null, null, null, null,
				null);
	}

	public void esegui(String host, String identifierType, String identifierValue, String ipClient, String identifier,
			String actualFileName, String originalFileName, String agentIdentifier, String agentName,
			String rightsIdentifierType, String rightsIdentifierValue, String rightsDisseminateType, String loginUtente,
			String PasswordUtente) {
		AuthenticationUserLibraryPortTypeProxy proxy = null;
		AuthenticationUserOutput authenticationUserOutput = null;
		String url = null;

		try {
			url = "http://" + host + "/MagazziniDigitaliServices/services/AuthenticationUserLibraryPort?wsdl";

			proxy = new AuthenticationUserLibraryPortTypeProxy(url);

			authenticationUserOutput = proxy.authenticationUserLibraryOperation(
					genAuthenticationUserInput(identifierType, identifierValue, ipClient, identifier, actualFileName,
							originalFileName, agentIdentifier, agentName, rightsIdentifierType, rightsIdentifierValue,
							rightsDisseminateType, loginUtente, PasswordUtente));

			print(authenticationUserOutput);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private AuthenticationUserInput genAuthenticationUserInput(String identifierType, String identifierValue,
			String ipClient, String identifier, String actualFileName, String originalFileName, String agentIdentifier,
			String agentName, String rightsIdentifierType, String rightsIdentifierValue, String rightsDisseminateType,
			String loginUtente, String PasswordUtente) throws NoSuchAlgorithmException {
		AuthenticationUserInput authenticationUserInput = null;

		try {
			authenticationUserInput = new AuthenticationUserInput();
			authenticationUserInput.setUserInput(gerUserInput(identifierType, identifierValue, ipClient, identifier,
					actualFileName, originalFileName, agentIdentifier, agentName, rightsIdentifierType,
					rightsIdentifierValue, rightsDisseminateType, loginUtente, PasswordUtente));
		} catch (NoSuchAlgorithmException e) {
			throw e;
		}

		return authenticationUserInput;
	}

	private UserInput gerUserInput(String identifierType, String identifierValue, String ipClient, String identifier,
			String actualFileName, String originalFileName, String agentIdentifier, String agentName,
			String rightsIdentifierType, String rightsIdentifierValue, String rightsDisseminateType, String loginUtente,
			String PasswordUtente) throws NoSuchAlgorithmException {
		UserInput userInput = null;

		try {
			userInput = new UserInput();

			userInput.setObjectIdentifier(genObjectIdentifier(identifierType, identifierValue));
			userInput.setSoftware(genSoftware());
			userInput.setIpClient(ipClient);
			if (identifier != null) {
				userInput.setIdentifier(identifier);
				userInput.setActualFileName(actualFileName);
				userInput.setOriginalFileName(originalFileName);
				userInput.setAgent(genAgent(agentIdentifier, agentName));
				userInput.setRights(genRights(rightsIdentifierType, rightsIdentifierValue, rightsDisseminateType));
				userInput.setAuthentication(genAuthentication(loginUtente, PasswordUtente));
			}
		} catch (NoSuchAlgorithmException e) {
			throw e;
		}
		return userInput;
	}

	private UserInputAgent genAgent(String agentIdentifier, String agentName) {
		UserInputAgent userInputAgent = null;

		userInputAgent = new UserInputAgent(agentIdentifier, agentName);
		return userInputAgent;
	}

	private UserInputRights genRights(String rightsIdentifierType, String rightsIdentifierValue,
			String rightsDisseminateType) {
		UserInputRights userInputRights = null;

		userInputRights = new UserInputRights(
				new UserInputRightsRightsIdentifier(rightsIdentifierType, rightsIdentifierValue),
				new UserInputRightsRightsDisseminate(
						UserInputRightsRightsDisseminateRightsDisseminateType.fromString(rightsDisseminateType)));
		return userInputRights;
	}

	private UserInputAuthentication genAuthentication(String loginUtente, String passwordUtente) {
		UserInputAuthentication userInputAuthentication = null;

		userInputAuthentication = new UserInputAuthentication(loginUtente, passwordUtente);
		return userInputAuthentication;
	}

	private UserInputSoftware genSoftware() throws NoSuchAlgorithmException {
		UserInputSoftware userInputSoftware = null;

		try {
			userInputSoftware = new UserInputSoftware();
			userInputSoftware.setAuthentication(genAuthentication());
			userInputSoftware.setId("51557609-f3b5-4cd9-9210-62ef51177536");
		} catch (NoSuchAlgorithmException e) {
			throw e;
		}

		return userInputSoftware;
	}

	private UserInputSoftwareAuthentication genAuthentication() throws NoSuchAlgorithmException {
		UserInputSoftwareAuthentication userInputSoftwareAuthentication = null;
		SHA256Tools sha256Tools = null;

		try {
			userInputSoftwareAuthentication = new UserInputSoftwareAuthentication();
			userInputSoftwareAuthentication.setLogin("GS_MD");
			sha256Tools = new SHA256Tools();
			userInputSoftwareAuthentication.setPassword(sha256Tools.checkSum("m@9@221n1".getBytes()));
		} catch (NoSuchAlgorithmException e) {
			throw e;
		}

		return userInputSoftwareAuthentication;
	}

	private UserInputObjectIdentifier genObjectIdentifier(String identifierType, String identifierValue) {
		UserInputObjectIdentifier objectIdentifier = null;

		objectIdentifier = new UserInputObjectIdentifier();
		objectIdentifier.setObjectIdentifierType(identifierType);
		objectIdentifier.setObjectIdentifierValue(identifierValue);

		return objectIdentifier;
	}

}
