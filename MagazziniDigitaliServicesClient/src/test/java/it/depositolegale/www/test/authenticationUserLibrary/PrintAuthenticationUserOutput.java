/**
 * 
 */
package it.depositolegale.www.test.authenticationUserLibrary;

import it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutput;
import it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutputRights;
import it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutputRightsRightsDisseminate;
import it.depositolegale.www.authenticationUserOutput.AuthenticationUserOutputRightsRightsIdentifier;

/**
 * @author massi
 *
 */
public class PrintAuthenticationUserOutput extends PrintAuthenticationUserInput {

	/**
	 * 
	 */
	public PrintAuthenticationUserOutput() {
	}

	protected void print(AuthenticationUserOutput authenticationUserOutput) {

		print(authenticationUserOutput.getUserInput(),"");
		print(authenticationUserOutput.getAgent(),"");
		print(authenticationUserOutput.getRights(),"");
		print(authenticationUserOutput.getErrorMsg(),"");
		print("URL",authenticationUserOutput.getUrl(),"");
	}

	private void print(AuthenticationUserOutputRights rights, String prefix) {
		if (rights != null){
			System.out.println(prefix+"AuthenticationUserOutputRights");
			prefix +="\t";
			print(rights.getRightsIdentifier(), prefix);
			print(rights.getRightsDisseminate(), prefix);
		}
	}

	private void print(AuthenticationUserOutputRightsRightsDisseminate rightsDisseminate, String prefix) {
		if (rightsDisseminate != null){
			System.out.println(prefix+"AuthenticationUserOutputRightsRightsDisseminate");
			prefix +="\t";
			print("RightsDisseminateType",rightsDisseminate.getRightsDisseminateType().getValue(),prefix);
		}
	}

	private void print(AuthenticationUserOutputRightsRightsIdentifier rightsIdentifier, String prefix) {
		if (rightsIdentifier != null){
			System.out.println(prefix+"AuthenticationUserOutputRightsRightsIdentifier");
			prefix +="\t";
			print("RightsIdentifierType",rightsIdentifier.getRightsIdentifierType(), prefix);
			print("RightsIdentifierValue",rightsIdentifier.getRightsIdentifierValue(), prefix);
		}
	}

}
