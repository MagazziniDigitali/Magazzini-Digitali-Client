/**
 * 
 */
package it.depositolegale.www.test.authenticationUserLibrary;

import it.depositolegale.www.authenticationUserInput.Agent;
import it.depositolegale.www.authenticationUserInput.UserInput;
import it.depositolegale.www.authenticationUserInput.UserInputAgent;
import it.depositolegale.www.authenticationUserInput.UserInputAuthentication;
import it.depositolegale.www.authenticationUserInput.UserInputObjectIdentifier;
import it.depositolegale.www.authenticationUserInput.UserInputRights;
import it.depositolegale.www.authenticationUserInput.UserInputRightsRightsDisseminate;
import it.depositolegale.www.authenticationUserInput.UserInputRightsRightsIdentifier;
import it.depositolegale.www.authenticationUserInput.UserInputSoftware;
import it.depositolegale.www.authenticationUserInput.UserInputSoftwareAuthentication;
import it.depositolegale.www.authenticationUserInput.UserInputSoftwareIstituzione;
import it.depositolegale.www.authenticationUserInput.UserInputSoftwareIstituzioneApiUtente;
import it.depositolegale.www.authenticationUserInput.UserInputSoftwareRigth;
import it.depositolegale.www.test.software.PrintSoftware;

/**
 * @author massi
 *
 */
public class PrintAuthenticationUserInput extends PrintSoftware {

	/**
	 * 
	 */
	public PrintAuthenticationUserInput() {
	}

	protected void print(UserInput userInput, String prefix) {
		if (userInput != null) {
			System.out.println(prefix + "UserInput");
			prefix += "\t";
			print(userInput.getObjectIdentifier(), prefix);
			print(userInput.getSoftware(), prefix);
			print("IpClient", userInput.getIpClient(), prefix);
			print("Identifier", userInput.getIdentifier(), prefix);
			print("ActualFileName", userInput.getActualFileName(), prefix);
			print("OriginalFileName", userInput.getOriginalFileName(), prefix);
			print(userInput.getAgent(), prefix);
			print(userInput.getRights(), prefix);
			print(userInput.getAuthentication(), prefix);
		}
	}

	private void print(UserInputAuthentication authentication, String prefix) {
		if (authentication != null) {
			System.out.println(prefix + "UserInputAuthentication");
			prefix += "\t";
			print("Login", authentication.getLogin(), prefix);
			print("Password", authentication.getPassword(), prefix);
		}
	}

	private void print(UserInputRights rights, String prefix) {
		if (rights != null) {
			System.out.println(prefix + "UserInputRights");
			prefix += "\t";
			print(rights.getRightsIdentifier(), prefix);
			print(rights.getRightsDisseminate(), prefix);
		}
	}

	private void print(UserInputRightsRightsDisseminate rightsDisseminate, String prefix) {
		if (rightsDisseminate != null) {
			System.out.println(prefix + "UserInputRightsRightsDisseminate");
			prefix += "\t";
			print("RightsDisseminateType", rightsDisseminate.getRightsDisseminateType().getValue(), prefix);
		}
	}

	private void print(UserInputRightsRightsIdentifier rightsIdentifier, String prefix) {
		if (rightsIdentifier != null) {
			System.out.println(prefix + "UserInputRightsRightsIdentifier");
			prefix += "\t";
			print("RightsIdentifierType", rightsIdentifier.getRightsIdentifierType(), prefix);
			print("RightsIdentifierValue", rightsIdentifier.getRightsIdentifierValue(), prefix);
		}
	}

	private void print(UserInputAgent agent, String prefix) {
		if (agent != null) {
			System.out.println(prefix + "UserInputAgent");
			prefix += "\t";
			print("AgentIdentifier", agent.getAgentIdentifier(), prefix);
			print("AgentName", agent.getAgentName(), prefix);
		}
	}

	private void print(UserInputSoftware software, String prefix) {
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

	private void print(UserInputSoftwareRigth rigth, String prefix) {
		if (rigth != null) {
			System.out.println(prefix + "UserInputSoftwareRigth");
			prefix += "\t";
			print("ID", rigth.getId(), prefix);
			print("Nome", rigth.getNome(), prefix);
			print("Type", rigth.getType().getValue(), prefix);
		}
	}

	private void print(UserInputSoftwareIstituzione istituzione, String prefix) {
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

	private void print(UserInputSoftwareIstituzioneApiUtente apiUtente, String prefix) {
		if (apiUtente != null) {
			System.out.println(prefix + "UserInputSoftwareIstituzioneApiUtente");
			prefix += "\t";
			print("Interfaccia", apiUtente.getInterfaccia(), prefix);
			print("Libreria", apiUtente.getLibreria(), prefix);
		}
	}

	private void print(UserInputSoftwareAuthentication authentication, String prefix) {
		if (authentication != null) {
			System.out.println(prefix + "UserInputSoftwareAuthentication");
			prefix += "\t";
			print("Login", authentication.getLogin(), prefix);
			print("Password", authentication.getPassword(), prefix);
		}
	}

	private void print(UserInputObjectIdentifier objectIdentifier, String prefix) {
		if (objectIdentifier != null) {
			System.out.println(prefix + "UserInputObjectIdentifier");
			prefix += "\t";
			print("ObjectIdentifierType", objectIdentifier.getObjectIdentifierType(), prefix);
			print("ObjectIdentifierValue", objectIdentifier.getObjectIdentifierValue(), prefix);
		}
	}

	protected void print(Agent[] agent, String prefix) {
		if (agent != null && agent.length>0){
			System.out.println(prefix+"Agent");
			prefix +="\t";
			for (int x=0; x<agent.length;x++){
				if (x>0){
					System.out.println(prefix+"--------------------------------");
				}
				print(agent[x], prefix);
			}
		}
	}

	private void print(Agent agent, String prefix) {
		if (agent != null) {
			System.out.println(prefix + "Agent");
			prefix += "\t";
			print("AgentIdentifier", agent.getAgentIdentifier(), prefix);
			print("AgentName", agent.getAgentName(), prefix);
		}
	}

}
