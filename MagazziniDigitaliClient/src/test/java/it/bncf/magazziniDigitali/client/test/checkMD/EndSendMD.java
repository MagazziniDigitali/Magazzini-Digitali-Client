/**
 * 
 */
package it.bncf.magazziniDigitali.client.test.checkMD;

import java.rmi.RemoteException;
import java.util.GregorianCalendar;

import it.bncf.magazziniDigitali.configuration.IMDConfiguration;
import it.depositolegale.configuration.MDConfiguration;
import it.depositolegale.software.ConverterEndSendReadInfoOutputSoftware;
import it.depositolegale.www.endSend.EndSend;
import it.depositolegale.www.endSend.EndSendReadInfoOutput;
import it.depositolegale.www.endSend.EndSendReadInfoOutputOggettoDigitale;
import it.depositolegale.www.software.Software;
import it.depositolegale.www.webservice_endSendMD.EndSendMDPortTypeProxy;

/**
 * @author massi
 *
 */
public class EndSendMD {

	/**
	 * 
	 */
	public EndSendMD() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IMDConfiguration<Software> configuration = null;
		ConverterEndSendReadInfoOutputSoftware converterReadInfoInputSoftware = null;

		EndSendMDPortTypeProxy proxy = null;
		EndSend endSend = null;
		EndSendReadInfoOutput readInfoOutput = null;
		
//		ReadInfoOutput output = null;
//		EndSendReadInfoOutputIstituto istituto = null;
		EndSendReadInfoOutputOggettoDigitale oggettoDigitale = null;
//		Digest[] digest = null;
		String url = null;
		String idOggettoDigitale = "ff989e7e-dd39-4054-b1ef-bb47377be3d5";
		String idIstituto = "IBNF1";
		String pwdIstituto = "222222";
		GregorianCalendar lastModified = new GregorianCalendar();
		String nomeFile="pippo.tar.gz";

		try {
//			if (args.length==2){
			configuration = new MDConfiguration("TD", 
					"file:////Users/massi/Desktop/Lavoro/Sorgenti/Bncf/MagazziniDigitaliClient/MagazziniDigitaliClient/configurazione/new", 
					"G@l@ss1@");

			
			url = configuration.getSoftwareConfigString("wsdlEndSendMD");

				System.out.println("initSendMD: "+url+" idOggettoDigitale: "+idOggettoDigitale);
				proxy = new EndSendMDPortTypeProxy(url);
	
				endSend = new EndSend();
				endSend.setEsito(true);
	
				readInfoOutput = new EndSendReadInfoOutput();
				System.out.println("istituto.id: "+idIstituto);
				System.out.println("istituto.password: "+pwdIstituto);
				converterReadInfoInputSoftware = new ConverterEndSendReadInfoOutputSoftware();
				readInfoOutput.setSoftware(converterReadInfoInputSoftware.convert(configuration.getSoftware()));
	
				System.out.println("lastModified: "+lastModified);
				oggettoDigitale = new EndSendReadInfoOutputOggettoDigitale();
				oggettoDigitale.setId(idOggettoDigitale);
				oggettoDigitale.setNomeFile(nomeFile);
//				digest = new Digest[1];
//				digest[0] = new Digest();
//				digest[0].setDigestType(Digest_type.SHA1);
//				digest[0].setDigestValue(hash);
//				oggettoDigitale.setDigest(digest);
				oggettoDigitale.setUltimaModifica(lastModified);
				readInfoOutput.setOggettoDigitale(oggettoDigitale);;

				endSend.setReadInfoOutput(readInfoOutput);
				
				
				proxy.endSendMDOperation(endSend);
//				if (output != null){
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
//					if (output.getOggettoDigitale()!=null){
//						System.out.println("output.getOggettoDigitale().getId: "+output.getOggettoDigitale().getId());
//						System.out.println("output.getOggettoDigitale().getNomeFile: "+output.getOggettoDigitale().getNomeFile());
//						if (output.getOggettoDigitale().getStatoOggettoDigitale()!=null){
//							System.out.println("output.getOggettoDigitale().getStatoOggettoDigitale().getValue: "+output.getOggettoDigitale().getStatoOggettoDigitale().getValue());
//						} else {
//							System.out.println("output.getOggettoDigitale().getStatoOggettoDigitale == null");
//						}
//						System.out.println("output.getOggettoDigitale().getUltimaModifica: "+output.getOggettoDigitale().getUltimaModifica());
//					} else {
//						System.out.println("output.getOggettoDigitale == null");
//					}
//				} else {
//					System.out.println("output == null");
//				}
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
