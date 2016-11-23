/**
 * 
 */
package it.depositolegale.software;

import it.depositolegale.www.readInfoInput.ReadInfoInputSoftware;
import it.depositolegale.www.readInfoInput.ReadInfoInputSoftwareAuthentication;
import it.depositolegale.www.readInfoInput.ReadInfoInputSoftwareIstituzione;
import it.depositolegale.www.readInfoInput.ReadInfoInputSoftwareIstituzioneApiUtente;
import it.depositolegale.www.readInfoInput.ReadInfoInputSoftwareRigth;
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
public class ConverterReadInfoInputSoftware {

	/**
	 * 
	 */
	public ConverterReadInfoInputSoftware() {
	}

	public ReadInfoInputSoftware convert(Software software){
		ReadInfoInputSoftware authenticationUtentiSoftware = null;
		
		authenticationUtentiSoftware = new ReadInfoInputSoftware();
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

	private ReadInfoInputSoftwareAuthentication convert(SoftwareAuthentication softwareAuthentication){
		ReadInfoInputSoftwareAuthentication authenticationUtentiSoftwareAuthentication = null;
		
		authenticationUtentiSoftwareAuthentication = new ReadInfoInputSoftwareAuthentication();
		authenticationUtentiSoftwareAuthentication.setLogin(softwareAuthentication.getLogin());
		authenticationUtentiSoftwareAuthentication.setPassword(softwareAuthentication.getPassword());
		return authenticationUtentiSoftwareAuthentication;
	}

	private ReadInfoInputSoftwareIstituzione convert(SoftwareIstituzione softwareIstituzione){
		ReadInfoInputSoftwareIstituzione authenticationUtentiSoftwareIstituzione = null;
		
		authenticationUtentiSoftwareIstituzione = new ReadInfoInputSoftwareIstituzione();
		
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
	
	private ReadInfoInputSoftwareIstituzioneApiUtente convert(SoftwareIstituzioneApiUtente softwareIstituzioneApiUtente){
		ReadInfoInputSoftwareIstituzioneApiUtente authenticationUtentiSoftwareIstituzioneApiUtente = null;
		
		authenticationUtentiSoftwareIstituzioneApiUtente = new ReadInfoInputSoftwareIstituzioneApiUtente();
		authenticationUtentiSoftwareIstituzioneApiUtente.setInterfaccia(softwareIstituzioneApiUtente.getInterfaccia());
		authenticationUtentiSoftwareIstituzioneApiUtente.setLibreria(softwareIstituzioneApiUtente.getLibreria());
		return authenticationUtentiSoftwareIstituzioneApiUtente;
	}

	private ReadInfoInputSoftwareRigth convert(SoftwareRigth softwareRigth){
		ReadInfoInputSoftwareRigth authenticationUtentiSoftwareRigth = null;
		
		authenticationUtentiSoftwareRigth = new ReadInfoInputSoftwareRigth();
		authenticationUtentiSoftwareRigth.setId(softwareRigth.getId());
		authenticationUtentiSoftwareRigth.setNome(softwareRigth.getNome());
		authenticationUtentiSoftwareRigth.setType(softwareRigth.getType());
		return authenticationUtentiSoftwareRigth;
	}


	public ReadInfoInputSoftware convert(ReadInfoOutputSoftware software){
		ReadInfoInputSoftware authenticationUtentiSoftware = null;
		
		authenticationUtentiSoftware = new ReadInfoInputSoftware();
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

	private ReadInfoInputSoftwareAuthentication convert(ReadInfoOutputSoftwareAuthentication softwareAuthentication){
		ReadInfoInputSoftwareAuthentication authenticationUtentiSoftwareAuthentication = null;
		
		authenticationUtentiSoftwareAuthentication = new ReadInfoInputSoftwareAuthentication();
		authenticationUtentiSoftwareAuthentication.setLogin(softwareAuthentication.getLogin());
		authenticationUtentiSoftwareAuthentication.setPassword(softwareAuthentication.getPassword());
		return authenticationUtentiSoftwareAuthentication;
	}

	private ReadInfoInputSoftwareIstituzione convert(ReadInfoOutputSoftwareIstituzione softwareIstituzione){
		ReadInfoInputSoftwareIstituzione authenticationUtentiSoftwareIstituzione = null;
		
		authenticationUtentiSoftwareIstituzione = new ReadInfoInputSoftwareIstituzione();
		
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
	
	private ReadInfoInputSoftwareIstituzioneApiUtente convert(ReadInfoOutputSoftwareIstituzioneApiUtente softwareIstituzioneApiUtente){
		ReadInfoInputSoftwareIstituzioneApiUtente authenticationUtentiSoftwareIstituzioneApiUtente = null;
		
		authenticationUtentiSoftwareIstituzioneApiUtente = new ReadInfoInputSoftwareIstituzioneApiUtente();
		authenticationUtentiSoftwareIstituzioneApiUtente.setInterfaccia(softwareIstituzioneApiUtente.getInterfaccia());
		authenticationUtentiSoftwareIstituzioneApiUtente.setLibreria(softwareIstituzioneApiUtente.getLibreria());
		return authenticationUtentiSoftwareIstituzioneApiUtente;
	}

	private ReadInfoInputSoftwareRigth convert(ReadInfoOutputSoftwareRigth softwareRigth){
		ReadInfoInputSoftwareRigth authenticationUtentiSoftwareRigth = null;
		
		authenticationUtentiSoftwareRigth = new ReadInfoInputSoftwareRigth();
		authenticationUtentiSoftwareRigth.setId(softwareRigth.getId());
		authenticationUtentiSoftwareRigth.setNome(softwareRigth.getNome());
		authenticationUtentiSoftwareRigth.setType(softwareRigth.getType());
		return authenticationUtentiSoftwareRigth;
	}
}
