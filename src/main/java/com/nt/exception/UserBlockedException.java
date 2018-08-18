/**
 * 
 */
package com.nt.exception;

/**
 * @author abc
 *
 */
public class UserBlockedException extends Exception{
	/**
	 * Creates user obj without error decription
	 */
	public UserBlockedException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Creates user obj with error decription
	 * @param errDescp
	 */
	public UserBlockedException(String errDescp) {
		super(errDescp);
	}
}
