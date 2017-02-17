/**
 * 
 */
package it.depositolegale.www.test.numberView;

import java.math.BigInteger;
import java.rmi.RemoteException;

import it.depositolegale.www.numberView.NumberView;
import it.depositolegale.www.webservice.numberView.NumberViewPortTypeProxy;

/**
 * @author massi
 *
 */
public class NumberViewTest {

	/**
	 * 
	 */
	public NumberViewTest() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberViewTest numberViewTest = null;

		if (args.length==2){
			numberViewTest = new NumberViewTest();
			numberViewTest.esegui(args[0], args[1]);
		} else {
			System.out.println("Indicare i seguenti parametri:");
			System.out.println("1) L'indirizzo del server da contattare");
			System.out.println("2) Identificativo Oggetto");
		}
	}

	private void esegui(String host, String id) {
		NumberViewPortTypeProxy proxy = null;
		String url = null;
		BigInteger number = null;
		NumberView numberView = null;
		
		try {
			url = "http://"+host+"/MagazziniDigitaliServices/services/NumberViewPort?wsdl";
			System.out.println("URL: "+url);
			proxy = new NumberViewPortTypeProxy(url);
			System.out.println("ID: "+id);
			numberView = new NumberView();
			numberView.setIdObject(id);
			number = proxy.numberViewOperation(numberView);
			
			System.out.println("ID: "+id+" Record: "+(number==null?0:number.intValue()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
