/**
 * 
 */
package it.bncf.magazziniDigitali.client.test.checkMD;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;

import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.depositolegale.configuration.MDConfiguration;
import it.depositolegale.software.ConverterReadInfoInputSoftware;
import it.depositolegale.www.oggettiDigitali.Digest;
import it.depositolegale.www.oggettiDigitali.Digest_type;
import it.depositolegale.www.readInfoInput.ReadInfoInput;
import it.depositolegale.www.readInfoInput.ReadInfoInputOggettoDigitale;
import it.depositolegale.www.readInfoOutput.ReadInfoOutput;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.webservice_checkMD.CheckMDPortTypeProxy;

/**
 * @author massi
 *
 */
public class CheckMD {

	/**
	 * 
	 */
	public CheckMD() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IMDConfiguration<Software> configuration = null;
		ConverterReadInfoInputSoftware converterReadInfoInputSoftware = null;

		CheckMDPortTypeProxy proxy = null;
		ReadInfoInput input = null;
		ReadInfoOutput output = null;
//		ReadInfoInputIstituto istituto = null;
		ReadInfoInputOggettoDigitale oggettoDigitale = null;
		Digest[] digest = null;
		String url = null;
		String hash = null;
		String idIstituto = "ASP1";
		String pwdIstituto = "NXaUV1FeeAvX";
		GregorianCalendar lastModified = new GregorianCalendar();
		String nomeFile="pippo.tar.gz";

		try {
//			if (args.length==2){
				configuration = new MDConfiguration("TD", 
						"file:////Users/massi/Desktop/Lavoro/Sorgenti/Bncf/MagazziniDigitaliClient/MagazziniDigitaliClient/configurazione/new", 
						"G@l@ss1@");

				
				url = configuration.getSoftwareConfigString("wsdlCheckMD");
				hash="1234567890";

				System.out.println("checkMD: "+url+" sha1: "+hash);
				proxy = new CheckMDPortTypeProxy(url);
	
				input = new ReadInfoInput();
	
				System.out.println("istituto.id: "+idIstituto);
				System.out.println("istituto.password: "+pwdIstituto);
				converterReadInfoInputSoftware = new ConverterReadInfoInputSoftware();
				input.setSoftware(converterReadInfoInputSoftware.convert(configuration.getSoftware()));
	
				System.out.println("lastModified: "+lastModified);
				oggettoDigitale = new ReadInfoInputOggettoDigitale();
				oggettoDigitale.setNomeFile(nomeFile);
				digest = new Digest[1];
				digest[0] = new Digest();
				digest[0].setDigestType(Digest_type.SHA1);
				digest[0].setDigestValue(hash);
				oggettoDigitale.setDigest(digest);
				oggettoDigitale.setUltimaModifica(lastModified);
				input.setOggettoDigitale(oggettoDigitale);
				output = proxy.checkMDOperation(input);
				if (output != null){
//					if (output.getIstituto() != null){
//						System.out.println("output.getIstituto().getId: "+output.getIstituto().getId());
//						System.out.println("output.getIstituto().getNome: "+output.getIstituto().getNome());
//						System.out.println("output.getIstituto().getPassword: "+output.getIstituto().getPassword());
//						if(output.getIstituto().getStatoIstituto()!= null){
//							System.out.println("output.getIstituto().getStatoIstituto().getValue: "+output.getIstituto().getStatoIstituto().getValue());
//						} else {
//							System.out.println("output.getIstituto().getStatoIstituto == null");
//						}
//					} else {
//						System.out.println("output.getIstituto == null");
//					}
					if (output.getOggettoDigitale()!=null){
						System.out.println("output.getOggettoDigitale().getId: "+output.getOggettoDigitale().getId());
						System.out.println("output.getOggettoDigitale().getNomeFile: "+output.getOggettoDigitale().getNomeFile());
						if (output.getOggettoDigitale().getStatoOggettoDigitale()!=null){
							System.out.println("output.getOggettoDigitale().getStatoOggettoDigitale().getValue: "+output.getOggettoDigitale().getStatoOggettoDigitale().getValue());
						} else {
							System.out.println("output.getOggettoDigitale().getStatoOggettoDigitale == null");
						}
						System.out.println("output.getOggettoDigitale().getUltimaModifica: "+output.getOggettoDigitale().getUltimaModifica());
					} else {
						System.out.println("output.getOggettoDigitale == null");
					}
				} else {
					System.out.println("output == null");
				}
//			}
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
