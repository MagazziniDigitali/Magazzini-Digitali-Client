/**
 * 
 */
package it.depositolegale.www.test.authenticationSoftware;

import java.math.BigInteger;

import org.apache.axis.types.URI;

import it.depositolegale.www.errorMsg.ErrorMsg;
import it.depositolegale.www.rigths.RightType_type;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.software.SoftwareAuthentication;
import it.depositolegale.www.software.SoftwareConfig;
import it.depositolegale.www.software.SoftwareIstituzione;
import it.depositolegale.www.software.SoftwareIstituzioneApiUtente;
import it.depositolegale.www.software.SoftwareRigth;

/**
 * @author massi
 *
 */
public abstract class AuthenticationSoftwareImplement<S, A, I, IAU, R> extends AuthenticationSoftware {

	/**
	 * 
	 */
	public AuthenticationSoftwareImplement() {
	}

	protected S convertSoftware(Software software){
		S output = null;
		if (software != null){
			output = initSoftware(
					genAuthentication(software.getAuthentication()), 
					software.getErrorMsg(), 
					software.getId(), 
					software.getNome(), 
					genIstituzione(software.getIstituzione()),
					genRigth(software.getRigth()), 
					software.getSoftwareConfig());
		}
		return output;
	}

	private A genAuthentication(SoftwareAuthentication authentication) {
		A output = null;
		if (authentication != null){
			output = initAuthentication(authentication.getLogin(), authentication.getPassword());
		}
		return output;
	}

	protected abstract A initAuthentication(String login, String password);

	private I genIstituzione(SoftwareIstituzione istituzione) {
		I output = null;
		if (istituzione != null){
			output = initIstituzione(
					istituzione.getId(),
					istituzione.getNome(),
					istituzione.getIndirizzo(),
					istituzione.getTelefono(),
					istituzione.getNomeContatto(),
					istituzione.getBibliotecaDepositaria(),
					istituzione.getIstitutoCentrale(),
					istituzione.getIpAccreditati(),
					genApiUtente(istituzione.getApiUtente()),
					istituzione.getEmailBagit());
		}
		return output;
	}

	protected abstract I initIstituzione(String id, String nome, String indirizzo,
	           String telefono, String nomeContatto, BigInteger bibliotecaDepositaria, BigInteger istitutoCentrale,
	           String[] ipAccreditati, IAU apiUtente, String emailBagit);

	private IAU genApiUtente(SoftwareIstituzioneApiUtente apiUtente) {
		IAU output = null;
		
		if (apiUtente != null){
			output = initApiUtente(apiUtente.getInterfaccia(), apiUtente.getLibreria());
		}
		return output;
	}
	
	protected abstract IAU initApiUtente(URI interfaccia, String libreria) ;

	private R genRigth(SoftwareRigth rigth) {
		R output = null;
		if (rigth != null){
			output = initRigth(rigth.getId(), rigth.getNome(), rigth.getType());
		}
		return output;
	}

	protected abstract R initRigth(String id, String nome, RightType_type type);

	protected abstract S initSoftware(A a, ErrorMsg[] errorMsgs, String id, String nome, I istituzione, R softwareRigth, SoftwareConfig[] softwareConfigs);
	
	protected String readParam(SoftwareConfig[] softwareConfigs, String key){
		String output = null;
		for (int x=0; x<softwareConfigs.length; x++){
			if (softwareConfigs[x].getNome().equals(key)){
				output = softwareConfigs[x].getValue();
			}
		}
		return output;
	}
}
