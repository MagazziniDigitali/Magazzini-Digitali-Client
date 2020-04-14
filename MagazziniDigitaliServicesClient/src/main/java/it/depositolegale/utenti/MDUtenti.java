/**
 * 
 */
package it.depositolegale.utenti;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.httpclient.protocol.DefaultProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.bncf.magazziniDigitali.configuration.exception.MDConfigurationException;
import it.depositolegale.software.ConverterAuthenticationUtentiSoftware;
import it.depositolegale.www.loginUtenti.AuthenticationUtenti;
import it.depositolegale.www.loginUtenti.AuthenticationUtentiAuthentication;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.utenti.Utenti;
import it.depositolegale.www.webservice_authenticationUtenti.AuthenticationUtentiPortTypeProxy;
import mx.randalf.configuration.Configuration;
import mx.randalf.configuration.exception.ConfigurationException;
import mx.randalf.tools.SHA256Tools;

/**
 * Implementazione della classe utilizzata per gestire il colloquio con il Server di 
 * Authenticazione delle infomrazioni relative al Software
 * 
 * @author massi
 *
 */
public class MDUtenti {

	/**
	 * Variabile utilizzata per loggare l'applicazione
	 */
	private static Logger log = LogManager.getLogger(MDUtenti.class);

	/**
	 * Costruttore
	 * 
	 * @param nomeSW Nome del Software
	 * @param fileConfiguration File di configurazione locale
	 * @throws MDConfigurationException
	 */
	public MDUtenti() throws MDConfigurationException {
	}

	/**
	 * 
	 */
	public Utenti checkUtenti(IMDConfiguration<Software> configuration, String ipClient, String login, String loginPassword) throws MDConfigurationException {
		String url = null;
		AuthenticationUtentiPortTypeProxy proxy = null;
		AuthenticationUtenti authentication = null;
		SHA256Tools sha256Tools = null;
		String password = null;
		ConverterAuthenticationUtentiSoftware converterAuthenticationUtentiSoftware = null;
		Utenti utenti = null;
		
		try {
			url = Configuration.getValue("utenti.URLAuthentication");
			if (url.toLowerCase().trim().startsWith("https")){
				Protocol.registerProtocol("https", 
						new Protocol("https", new DefaultProtocolSocketFactory(), 443));
			}
			//"http://"+args[0]+"/MagazziniDigitaliServices/services/AuthenticationSoftwarePort?wsdl";
			proxy = new AuthenticationUtentiPortTypeProxy(url);

			authentication = new AuthenticationUtenti();

			sha256Tools = new SHA256Tools();
			password = sha256Tools.checkSum(loginPassword.getBytes());

			authentication.setAuthentication(new AuthenticationUtentiAuthentication(login, password));

			converterAuthenticationUtentiSoftware = new ConverterAuthenticationUtentiSoftware();
			authentication.setSoftware(converterAuthenticationUtentiSoftware.convert(configuration.getSoftware()));
			authentication.setIpClient(ipClient);

			utenti = proxy.authenticationUtentiOperation(authentication);
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
		return utenti;
	}
}
