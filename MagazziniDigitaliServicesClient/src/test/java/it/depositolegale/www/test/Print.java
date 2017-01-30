/**
 * 
 */
package it.depositolegale.www.test;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.apache.axis.types.URI;

/**
 * @author massi
 *
 */
public class Print {

	/**
	 * 
	 */
	public Print() {
	}

	protected void print(String key, String value, String prefix) {
		if (value != null){
			System.out.println(prefix+key+": "+value);
		}
	}

	protected void print(String key, String[] value, String prefix) {
		if (value != null && value.length>0){
			for (int x=0; x<value.length; x++){
				print(key, value[x], prefix);
			}
		}
	}

	protected void print(String key, BigInteger value, String prefix) {
		if (value != null){
			print(key, value.toString(), prefix);
		}
	}

	protected void print(String key, URI value, String prefix) {
		if (value != null){
			print(key, value.toString(), prefix);
		}
	}

	protected void print(String key, Calendar value, String prefix) {
		String data = "";
		DecimalFormat df2 = new DecimalFormat("00");
		DecimalFormat df4 = new DecimalFormat("0000");
		DecimalFormat df3 = new DecimalFormat("000");
		if (value != null){
			data = df2.format(value.get(Calendar.DAY_OF_MONTH))+
					"/"+
					df2.format(value.get(Calendar.MONTH)+1)+
					"/"+
					df4.format(value.get(Calendar.YEAR))+
					" "+
					df2.format(value.get(Calendar.HOUR_OF_DAY))+
					":"+
					df2.format(value.get(Calendar.MINUTE))+
					":"+
					df2.format(value.get(Calendar.SECOND))+
					"."+
					df3.format(value.get(Calendar.MILLISECOND));
			print(key, data, prefix);
		}
	}

}
