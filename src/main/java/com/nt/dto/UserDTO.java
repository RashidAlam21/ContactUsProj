/**
 * 
 */
package com.nt.dto;

import java.io.Serializable;

/**
 * @author abc
 *
 */
public class UserDTO implements Serializable{
	private Integer userId;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String loginName;
	private String password;
	private Integer role;
	private Integer loginStatus;
	
	/**
	 * 
	 */
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param name
	 * @param phone
	 * @param email
	 * @param address
	 * @param loginName
	 * @param password
	 * @param role
	 * @param loginStatus
	 */
	public UserDTO(Integer userId, String name, String phone, String email, String address, String loginName,
			String password, Integer role, Integer loginStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
		this.loginStatus = loginStatus;
	}
	

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}

	/**
	 * @return the loginStatus
	 */
	public Integer getLoginStatus() {
		return loginStatus;
	}

	/**
	 * @param loginStatus the loginStatus to set
	 */
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", loginName=" + loginName + ", password=" + password + ", role=" + role + ", loginStatus="
				+ loginStatus + "]";
	}
	
}
