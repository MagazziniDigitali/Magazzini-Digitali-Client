/**
 * 
 */
package it.depositolegale.www.test.errorMsg;

import it.depositolegale.www.errorMsg.ErrorMsg;
import it.depositolegale.www.test.Print;

/**
 * @author massi
 *
 */
public class PrintErrorMsg extends Print {

	/**
	 * 
	 */
	public PrintErrorMsg() {
	}

	protected void print(ErrorMsg[] errorMsg, String prefix) {
		if (errorMsg != null && errorMsg.length>0){
			System.out.println(prefix+"ErrorMsg");
			prefix +="\t";
			for (int x=0; x<errorMsg.length;x++){
				if (x>0){
					System.out.println(prefix+"--------------------------------");
				}
				print(errorMsg[x], prefix);
			}
		}
	}

	private void print(ErrorMsg errorMsg, String prefix) {
		prefix +="\t";
		print("ErrorType", errorMsg.getErrorType().getValue(), prefix);
		print("MsgError", errorMsg.getMsgError(), prefix);
	}

}
