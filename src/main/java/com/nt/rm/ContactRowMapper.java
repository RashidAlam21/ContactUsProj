/**
 * 
 */
package com.nt.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.domain.Contact;

/**
 * @author abc
 *
 */
public class ContactRowMapper implements RowMapper<Contact>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public Contact mapRow(ResultSet rs, int pos) throws SQLException {
		Contact contact=new Contact();
		contact.setContactId(rs.getInt("contactid"));
		contact.setUserId(rs.getInt("userid"));
		contact.setName(rs.getString("name"));
		contact.setPhone(rs.getString("phone"));
		contact.setEmail(rs.getString("Email"));
		contact.setAddress(rs.getString("address"));
		contact.setRemark(rs.getString("remark"));
		return contact;
	}

}
