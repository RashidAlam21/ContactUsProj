/**
 * 
 */
package com.nt.service;

import java.util.List;

import com.nt.dto.ContactDTO;

/**
 * @author abc
 *
 */
public interface ContactService {
	public int save(ContactDTO cdto);
	public int update(ContactDTO cdto);
	public int delete(Integer contactId);
	public int delete(Integer[] contactIds);
	public ContactDTO findById(Integer contactId);
	/**
	 * This method return all user contact (user who is looged in).
	 * @param userId
	 * @return
	 */
	public List<ContactDTO> findUserContact(Integer userId);
	/**
	 * This method search contact for user(userId) based on given free-text-criteria (txt)
	 * @param userId Useer who is logged in.
	 * @param txt criteria used to search-free text search  criteria.
	 * @return
	 */
	public List<ContactDTO> findUserContact(Integer userId,String txt);
}
