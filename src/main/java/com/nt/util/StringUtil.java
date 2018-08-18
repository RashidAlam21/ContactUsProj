/**
 * 
 */
package com.nt.util;

/**
 * This class contain utiltiy methods relatated to string  operations.
 * @author abc
 *
 *
 */
public class StringUtil {
	public static String toCommaSepratedString(Object[] items) {
		StringBuilder sb=new StringBuilder();
		for (Object item : items) {
			sb.append(item).append(",");
		}
		if(sb.length()>0) {
				sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

}
