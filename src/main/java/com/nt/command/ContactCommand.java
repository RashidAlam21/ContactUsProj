/**
 * 
 */
package com.nt.command;

/**
 * @author abc
 *
 */
public class ContactCommand {
	private Integer contactId;//pk
	private Integer userId;//Fk
	private String name;
	private String phone;
	private String email;
	private String address;
	private String remark;
	/**
	 * 
	 */
	public ContactCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param contactId
	 * @param userId
	 * @param name
	 * @param phone
	 * @param email
	 * @param address
	 * @param remark
	 */
	public ContactCommand(Integer contactId, Integer userId, String name, String phone, String email, String address,
			String remark) {
		super();
		this.contactId = contactId;
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.remark = remark;
	}
	/**
	 * @return the contactId
	 */
	public Integer getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", userId=" + userId + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", remark=" + remark + "]";
	}
	
	
}
