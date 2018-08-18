/**
 * 
 */
package com.nt.dao;

import java.util.List;

import com.nt.domain.Contact;
import com.nt.domain.User;
import com.nt.dto.ContactDTO;

/**
 * @author abc
 *
 */
public interface ContactDAO {
	public int save(Contact cnt);
	public int update(Contact cnt);
	public int delete(Contact cnt);
	public int deleteById(Integer contactId);
	public Contact findById(Integer contactId);
	public List<Contact> findAll();
	public List<Contact> findProperty(String propName,Object propValue);
	public List<Contact> findUserContact(Integer userId,String txt);
}
