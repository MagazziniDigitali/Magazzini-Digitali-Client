/**
 * 
 */
package it.depositolegale.configuration;

import java.io.File;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.quartz.SchedulerException;
import org.quartz.Trigger.TriggerState;

import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.bncf.magazziniDigitali.configuration.exception.MDConfigurationException;
import it.bncf.magazziniDigitali.database.dao.MDNodiDAO;
import it.bncf.magazziniDigitali.database.dao.MDRigthsDAO;
import it.bncf.magazziniDigitali.database.dao.MDSoftwareDAO;
import it.bncf.magazziniDigitali.database.entity.MDNodi;
import it.bncf.magazziniDigitali.database.entity.MDRigths;
import it.bncf.magazziniDigitali.database.entity.MDSoftware;
import it.depositolegale.www.login.Authentication;
import it.depositolegale.www.nodi.Nodo;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.software.SoftwareConfigNodo;
import it.depositolegale.www.webservice_authenticationSoftware.AuthenticationSoftwarePortTypeProxy;
import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;
import mx.randalf.hibernate.exception.HibernateUtilException;
import mx.randalf.quartz.QuartzMaster;
import mx.randalf.tools.SHA256Tools;

/**
 * Implementazione della classe utilizzata per gestire il colloquio con il Server di 
 * Authenticazione delle infomrazioni relative al Software
 * 
 * @author massi
 *
 */
public class MDConfiguration extends IMDConfiguration<Software> {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private static Logger log = Logger.getLogger(MDConfiguration.class);

	private QuartzMaster quartzMaster = null;

	/**
	 * Costruttore
	 * 
	 * @param nomeSW Nome del Software
	 * @param fileConfiguration File di configurazione locale
	 * @throws MDConfigurationException
	 */
	public MDConfiguration(String nomeSW, String fileConfiguration) throws MDConfigurationException {
		super(nomeSW, fileConfiguration);
		File f = null;
		
		try {
			if (isSoftwareInizialize()){
				String quartzFile = this.getSoftwareConfigString("quartzFile");
				if (quartzFile != null){
					f = new File(pathProperties+
							File.separator+quartzFile);
					if (f.exists()){
						quartzMaster = new QuartzMaster(false, f.getAbsolutePath());
					} else {
						log.error("Ilf file ["+f.getAbsolutePath()+"] non esiste");
					}
				}
			}
		} catch (MDConfigurationException e){
		} catch (SchedulerException e) {
			throw new MDConfigurationException(e.getMessage(),e);
		}
	}

	/**
	 *  Costruttore 
	 *  
	 * @param nomeSW
	 * @param fileConfiguration
	 * @param sysPassword
	 * @throws MDConfigurationException
	 */
	public MDConfiguration(String nomeSW, String fileConfiguration, String sysPassword) throws MDConfigurationException {
		super(nomeSW, fileConfiguration, sysPassword);
	}

	/**
	 * @see it.bncf.magazziniDigitali.configuration.IMDConfiguration#isSoftwareInizialize()
	 */
	@Override
	protected boolean isSoftwareInizialize() {
		return (software!= null);
	}

	/**
	 * @see it.bncf.magazziniDigitali.configuration.IMDConfiguration#readConfiguration()
	 */
	@Override
	protected void readConfiguration() throws MDConfigurationException {
		String url = null;
		AuthenticationSoftwarePortTypeProxy proxy = null;
		Authentication authentication = null;
		SHA256Tools sha256Tools = null;
		String password = null;
		
		try {
			url = Configuration.getValue("software.URLAuthentication");
			//"http://"+args[0]+"/MagazziniDigitaliServices/services/AuthenticationSoftwarePort?wsdl";
			proxy = new AuthenticationSoftwarePortTypeProxy(url);

			authentication = new Authentication();
			authentication.setLogin(Configuration.getValue("software."+nomeSW+".login"));
			sha256Tools = new SHA256Tools();

			if (sysPassword != null){
				password = sha256Tools.checkSum(sysPassword.getBytes());
			} else {
				password = sha256Tools.checkSum(Configuration.getValue("software."+nomeSW+".password").getBytes());
			}
			authentication.setPassword(password);
			this.software = proxy.authenticationSoftwareOperation(authentication);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
			throw new MDConfigurationException(e.getMessage(), e);
		} catch (RemoteException e) {
			log.error(e.getMessage(), e);
			throw new MDConfigurationException(e.getMessage(), e);
		} catch (ConfigurationException e) {
			log.error(e.getMessage(), e);
			throw new MDConfigurationException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see it.bncf.magazziniDigitali.configuration.IMDConfiguration#getMDSoftware()
	 */
	@Override
	public MDSoftware getMDSoftware() throws MDConfigurationException {
		MDSoftwareDAO mdSoftwareBusiness = null;
		MDSoftware mdSoftware = null;
		
		try {
			mdSoftwareBusiness = new MDSoftwareDAO();
			mdSoftware = mdSoftwareBusiness.findById(software.getId());
		} catch (HibernateException e) {
			throw  new MDConfigurationException(e.getMessage(),e);
		} catch (HibernateUtilException e) {
			throw  new MDConfigurationException(e.getMessage(),e);
		}
		return mdSoftware;
	}

	/**
	 * @see it.bncf.magazziniDigitali.configuration.IMDConfiguration#getMDRigths()
	 */
	@Override
	public MDRigths getMDRigths() throws MDConfigurationException {
		MDRigthsDAO mdRigthsBusiness = null;
		MDRigths mdRigths = null;
		
		try {
			mdRigthsBusiness = new MDRigthsDAO();
			
			mdRigths = mdRigthsBusiness.findById(software.getRigth().getId());
		} catch (HibernateException e) {
			throw  new MDConfigurationException(e.getMessage(),e);
		} catch (HibernateUtilException e) {
			throw  new MDConfigurationException(e.getMessage(),e);
		}
		return mdRigths;
	}

	/**
	 * @see it.bncf.magazziniDigitali.configuration.IMDConfiguration#getSoftwareConfig(java.lang.String)
	 */
	@Override
	protected Object getSoftwareConfig(String key) throws MDConfigurationException {
		Object result = null;
		
		if (software!= null){
			if (software.getSoftwareConfig() != null && 
					software.getSoftwareConfig().length>0){
				for (int x=0; x<software.getSoftwareConfig().length; x++){
					if (software.getSoftwareConfig()[x].getNome().equals(key)){
						if (software.getSoftwareConfig()[x].getValue() != null){
							result = software.getSoftwareConfig()[x].getValue();
						} else if (software.getSoftwareConfig()[x].getNodo() != null){
							result = software.getSoftwareConfig()[x].getNodo();
						}
						break;
					}
				}
			}
			if (result== null){
				throw new MDConfigurationException("La chiave di configurazione ["+key+"] non è presente per il Software ["+software.getNome()+"]");
			}
		} else {
			throw new MDConfigurationException("Richiedere la autenticazione del Software");
		}
		return result;
	}

	/**
	 * @see it.bncf.magazziniDigitali.configuration.IMDConfiguration#getSoftwareConfigMDNodi(java.lang.String)
	 */
	@Override
	public MDNodi getSoftwareConfigMDNodi(String key) throws MDConfigurationException {
		Object result = null;
		SoftwareConfigNodo nodo = null;
		MDNodiDAO mdNodiBusiness = null;

		try {
			result = getSoftwareConfig(key);
			if (result != null){
				nodo = (SoftwareConfigNodo) result;
				mdNodiBusiness = new MDNodiDAO();
				
				return mdNodiBusiness.findById(nodo.getId());
			}else{
				return null;
			}
		} catch (HibernateException e) {
			throw new MDConfigurationException(e.getMessage(),e);
		} catch (HibernateUtilException e) {
			throw  new MDConfigurationException(e.getMessage(),e);
		}
	}

	@Override
	public Software getSoftware() {
		return software;
	}

	public String getStatoJob(String jobGroup, String jobName) throws MDConfigurationException {
		TriggerState triggerState = null;
		String result = "Non disponibile";
		
		try {
			triggerState = quartzMaster.getStatoJob(jobGroup, jobName);
			if (TriggerState.BLOCKED.equals(triggerState)){
				result = "Bloccato";
			} else if (TriggerState.COMPLETE.equals(triggerState)){
				result = "In Lavorazione";
			} else if (TriggerState.ERROR.equals(triggerState)){
				result = "Errore";
			} else if (TriggerState.NORMAL.equals(triggerState)){
				result = "In Attesa";
			} else if (TriggerState.PAUSED.equals(triggerState)){
				result = "Pausa";
			}
		} catch (SchedulerException e) {
			throw  new MDConfigurationException(e.getMessage(),e);
		}
		return result ;
	}

}
