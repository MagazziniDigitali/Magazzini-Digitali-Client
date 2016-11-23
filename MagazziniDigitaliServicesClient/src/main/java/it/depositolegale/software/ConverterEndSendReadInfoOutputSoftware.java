/**
 * 
 */
package it.depositolegale.software;

import it.depositolegale.www.endSend.EndSendReadInfoOutputSoftware;
import it.depositolegale.www.endSend.EndSendReadInfoOutputSoftwareAuthentication;
import it.depositolegale.www.endSend.EndSendReadInfoOutputSoftwareIstituzione;
import it.depositolegale.www.endSend.EndSendReadInfoOutputSoftwareIstituzioneApiUtente;
import it.depositolegale.www.endSend.EndSendReadInfoOutputSoftwareRigth;
import it.depositolegale.www.readInfoOutput.ReadInfoOutputSoftware;
import it.depositolegale.www.readInfoOutput.ReadInfoOutputSoftwareAuthentication;
import it.depositolegale.www.readInfoOutput.ReadInfoOutputSoftwareIstituzione;
import it.depositolegale.www.readInfoOutput.ReadInfoOutputSoftwareIstituzioneApiUtente;
import it.depositolegale.www.readInfoOutput.ReadInfoOutputSoftwareRigth;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.software.SoftwareAuthentication;
import it.depositolegale.www.software.SoftwareIstituzione;
import it.depositolegale.www.software.SoftwareIstituzioneApiUtente;
import it.depositolegale.www.software.SoftwareRigth;

/**
 * @author massi
 *
 */
public class ConverterEndSendReadInfoOutputSoftware {

	/**
	 * 
	 */
	public ConverterEndSendReadInfoOutputSoftware() {
	}

	public EndSendReadInfoOutputSoftware convert(Software software){
		EndSendReadInfoOutputSoftware authenticationUtentiSoftware = null;
		
		authenticationUtentiSoftware = new EndSendReadInfoOutputSoftware();
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

	private EndSendReadInfoOutputSoftwareAuthentication convert(SoftwareAuthentication softwareAuthentication){
		EndSendReadInfoOutputSoftwareAuthentication authenticationUtentiSoftwareAuthentication = null;
		
		authenticationUtentiSoftwareAuthentication = new EndSendReadInfoOutputSoftwareAuthentication();
		authenticationUtentiSoftwareAuthentication.setLogin(softwareAuthentication.getLogin());
		authenticationUtentiSoftwareAuthentication.setPassword(softwareAuthentication.getPassword());
		return authenticationUtentiSoftwareAuthentication;
	}

	private EndSendReadInfoOutputSoftwareIstituzione convert(SoftwareIstituzione softwareIstituzione){
		EndSendReadInfoOutputSoftwareIstituzione authenticationUtentiSoftwareIstituzione = null;
		
		authenticationUtentiSoftwareIstituzione = new EndSendReadInfoOutputSoftwareIstituzione();
		
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
	
	private EndSendReadInfoOutputSoftwareIstituzioneApiUtente convert(SoftwareIstituzioneApiUtente softwareIstituzioneApiUtente){
		EndSendReadInfoOutputSoftwareIstituzioneApiUtente authenticationUtentiSoftwareIstituzioneApiUtente = null;
		
		authenticationUtentiSoftwareIstituzioneApiUtente = new EndSendReadInfoOutputSoftwareIstituzioneApiUtente();
		authenticationUtentiSoftwareIstituzioneApiUtente.setInterfaccia(softwareIstituzioneApiUtente.getInterfaccia());
		authenticationUtentiSoftwareIstituzioneApiUtente.setLibreria(softwareIstituzioneApiUtente.getLibreria());
		return authenticationUtentiSoftwareIstituzioneApiUtente;
	}

	private EndSendReadInfoOutputSoftwareRigth convert(SoftwareRigth softwareRigth){
		EndSendReadInfoOutputSoftwareRigth authenticationUtentiSoftwareRigth = null;
		
		authenticationUtentiSoftwareRigth = new EndSendReadInfoOutputSoftwareRigth();
		authenticationUtentiSoftwareRigth.setId(softwareRigth.getId());
		authenticationUtentiSoftwareRigth.setNome(softwareRigth.getNome());
		authenticationUtentiSoftwareRigth.setType(softwareRigth.getType());
		return authenticationUtentiSoftwareRigth;
	}

	public EndSendReadInfoOutputSoftware convert(ReadInfoOutputSoftware software){
		EndSendReadInfoOutputSoftware authenticationUtentiSoftware = null;
		
		authenticationUtentiSoftware = new EndSendReadInfoOutputSoftware();
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

	private EndSendReadInfoOutputSoftwareAuthentication convert(ReadInfoOutputSoftwareAuthentication softwareAuthentication){
		EndSendReadInfoOutputSoftwareAuthentication authenticationUtentiSoftwareAuthentication = null;
		
		authenticationUtentiSoftwareAuthentication = new EndSendReadInfoOutputSoftwareAuthentication();
		authenticationUtentiSoftwareAuthentication.setLogin(softwareAuthentication.getLogin());
		authenticationUtentiSoftwareAuthentication.setPassword(softwareAuthentication.getPassword());
		return authenticationUtentiSoftwareAuthentication;
	}

	private EndSendReadInfoOutputSoftwareIstituzione convert(ReadInfoOutputSoftwareIstituzione softwareIstituzione){
		EndSendReadInfoOutputSoftwareIstituzione authenticationUtentiSoftwareIstituzione = null;
		
		authenticationUtentiSoftwareIstituzione = new EndSendReadInfoOutputSoftwareIstituzione();
		
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
	
	private EndSendReadInfoOutputSoftwareIstituzioneApiUtente convert(ReadInfoOutputSoftwareIstituzioneApiUtente softwareIstituzioneApiUtente){
		EndSendReadInfoOutputSoftwareIstituzioneApiUtente authenticationUtentiSoftwareIstituzioneApiUtente = null;
		
		authenticationUtentiSoftwareIstituzioneApiUtente = new EndSendReadInfoOutputSoftwareIstituzioneApiUtente();
		authenticationUtentiSoftwareIstituzioneApiUtente.setInterfaccia(softwareIstituzioneApiUtente.getInterfaccia());
		authenticationUtentiSoftwareIstituzioneApiUtente.setLibreria(softwareIstituzioneApiUtente.getLibreria());
		return authenticationUtentiSoftwareIstituzioneApiUtente;
	}

	private EndSendReadInfoOutputSoftwareRigth convert(ReadInfoOutputSoftwareRigth softwareRigth){
		EndSendReadInfoOutputSoftwareRigth authenticationUtentiSoftwareRigth = null;
		
		authenticationUtentiSoftwareRigth = new EndSendReadInfoOutputSoftwareRigth();
		authenticationUtentiSoftwareRigth.setId(softwareRigth.getId());
		authenticationUtentiSoftwareRigth.setNome(softwareRigth.getNome());
		authenticationUtentiSoftwareRigth.setType(softwareRigth.getType());
		return authenticationUtentiSoftwareRigth;
	}
}
