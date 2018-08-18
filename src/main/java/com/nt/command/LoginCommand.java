/**
 * 
 */
package com.nt.command;

import org.apache.log4j.Logger;

/**
 * @author abc
 *
 */
public class LoginCommand {
	private String loginName;
	private String password;
	private static final Logger logger=Logger.getLogger(LoginCommand.class);
	/**
	 * 
	 */
	public LoginCommand() {
		logger.info("LoginCommand : 0 Param Constructor");
	}
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginCommand [loginName=" + loginName + ", password=" + password + "]";
	}
	
}
