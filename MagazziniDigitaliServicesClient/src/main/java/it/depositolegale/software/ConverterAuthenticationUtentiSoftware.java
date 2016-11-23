/**
 * 
 */
package it.depositolegale.software;

import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftware;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftwareAuthentication;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftwareIstituzione;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftwareIstituzioneApiUtente;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiSoftwareRigth;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.software.SoftwareAuthentication;
import it.depositolegale.www.software.SoftwareIstituzione;
import it.depositolegale.www.software.SoftwareIstituzioneApiUtente;
import it.depositolegale.www.software.SoftwareRigth;

/**
 * @author massi
 *
 */
public class ConverterAuthenticationUtentiSoftware{

	/**
	 * 
	 */
	public ConverterAuthenticationUtentiSoftware() {
	}

	public AuthenticationUtentiSoftware convert(Software software){
		AuthenticationUtentiSoftware authenticationUtentiSoftware = null;
		
		authenticationUtentiSoftware = new AuthenticationUtentiSoftware();
		authenticationUtentiSoftware.setAuthentication(convert(software.getAuthentication()));
		if (software.getErrorMsg() != null &&
				software.getErrorMsg().length>0){
			authenticationUtentiSoftware.setErrorMsg(software.getErrorMsg());
		} else {
			authenticationUtentiSoftware.setId(software.getId());
			authenticationUtentiSoftware.setIstituzione(convert(software.getIstituzione()));
			authenticationUtentiSoftware.setNome(software.getNome());
			if (software.getRigth() != null){
				authenticationUtentiSoftware.setRigth(convert(software.getRigth()));
			}
			authenticationUtentiSoftware.setSoftwareConfig(software.getSoftwareConfig());
		}
		return authenticationUtentiSoftware;
	}

	private AuthenticationUtentiSoftwareAuthentication convert(SoftwareAuthentication softwareAuthentication){
		AuthenticationUtentiSoftwareAuthentication authenticationUtentiSoftwareAuthentication = null;
		
		authenticationUtentiSoftwareAuthentication = new AuthenticationUtentiSoftwareAuthentication();
		authenticationUtentiSoftwareAuthentication.setLogin(softwareAuthentication.getLogin());
		authenticationUtentiSoftwareAuthentication.setPassword(softwareAuthentication.getPassword());
		return authenticationUtentiSoftwareAuthentication;
	}

	private AuthenticationUtentiSoftwareIstituzione convert(SoftwareIstituzione softwareIstituzione){
		AuthenticationUtentiSoftwareIstituzione authenticationUtentiSoftwareIstituzione = null;
		
		authenticationUtentiSoftwareIstituzione = new AuthenticationUtentiSoftwareIstituzione();
		
		if (softwareIstituzione.getApiUtente()!=null){
			authenticationUtentiSoftwareIstituzione.setApiUtente(convert(softwareIstituzione.getApiUtente()));
		}
		authenticationUtentiSoftwareIstituzione.setBibliotecaDepositaria(softwareIstituzione.getBibliotecaDepositaria());
		authenticationUtentiSoftwareIstituzione.setEmailBagit(softwareIstituzione.getEmailBagit());
		authenticationUtentiSoftwareIstituzione.setId(softwareIstituzione.getId());
		authenticationUtentiSoftwareIstituzione.setIndirizzo(softwareIstituzione.getIndirizzo());
		authenticationUtentiSoftwareIstituzione.setIpAccreditati(softwareIstituzione.getIpAccreditati());
		authenticationUtentiSoftwareIstituzione.setIstitutoCentrale(softwareIstituzione.getIstitutoCentrale());
		authenticationUtentiSoftwareIstituzione.setNome(softwareIstituzione.getNome());
		authenticationUtentiSoftwareIstituzione.setNomeContatto(softwareIstituzione.getNomeContatto());
		authenticationUtentiSoftwareIstituzione.setTelefono(softwareIstituzione.getTelefono());
		return authenticationUtentiSoftwareIstituzione;
	}
	
	private AuthenticationUtentiSoftwareIstituzioneApiUtente convert(SoftwareIstituzioneApiUtente softwareIstituzioneApiUtente){
		AuthenticationUtentiSoftwareIstituzioneApiUtente authenticationUtentiSoftwareIstituzioneApiUtente = null;
		
		authenticationUtentiSoftwareIstituzioneApiUtente = new AuthenticationUtentiSoftwareIstituzioneApiUtente();
		authenticationUtentiSoftwareIstituzioneApiUtente.setInterfaccia(softwareIstituzioneApiUtente.getInterfaccia());
		authenticationUtentiSoftwareIstituzioneApiUtente.setLibreria(softwareIstituzioneApiUtente.getLibreria());
		return authenticationUtentiSoftwareIstituzioneApiUtente;
	}

	private AuthenticationUtentiSoftwareRigth convert(SoftwareRigth softwareRigth){
		AuthenticationUtentiSoftwareRigth authenticationUtentiSoftwareRigth = null;
		
		authenticationUtentiSoftwareRigth = new AuthenticationUtentiSoftwareRigth();
		authenticationUtentiSoftwareRigth.setId(softwareRigth.getId());
		authenticationUtentiSoftwareRigth.setNome(softwareRigth.getNome());
		authenticationUtentiSoftwareRigth.setType(softwareRigth.getType());
		return authenticationUtentiSoftwareRigth;
	}
}
