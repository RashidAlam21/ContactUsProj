/**
 * 
 */
package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BaseDAO;
import com.nt.dao.ContactDAO;
import com.nt.domain.Contact;
import com.nt.dto.ContactDTO;
import com.nt.util.StringUtil;

/**
 * @author abc
 *
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
	@Autowired
	private ContactDAO contactDAO;
	@Override
	public int save(ContactDTO cdto) {
		int status=0;
		Contact contact=new Contact();
		contact.setContactId(cdto.getContactId());
		contact.setUserId(cdto.getUserId());
		contact.setName(cdto.getName());
		contact.setPhone(cdto.getPhone());
		contact.setEmail(cdto.getEmail());
		contact.setAddress(cdto.getAddress());
		contact.setRemark(cdto.getRemark());
		status=contactDAO.save(contact);
		return status;
	}

	@Override
	public int update(ContactDTO cdto) {
		int status=0;
		Contact contact=new Contact();
		contact.setContactId(cdto.getContactId());
		//contact.setPhone(cdto.getPhone());
		contact.setName(cdto.getName());
		contact.setPhone(cdto.getPhone());
		contact.setEmail(cdto.getEmail());
		contact.setAddress(cdto.getAddress());
		contact.setRemark(cdto.getRemark());
		status=contactDAO.update(contact);
		return status;
	}

	@Override
	public int delete(Integer contactId) {
		int status=0;
		status=contactDAO.deleteById(contactId);
		return status;
	}


	@Override
	public int delete(Integer[] contactIds) {
		String ids=StringUtil.toCommaSepratedString(contactIds);
		String sql="delete from contact where contactId IN("+ids+")";
		return getJdbcTemplate().update(sql);
	}


	@Override
	public List<ContactDTO> findUserContact(Integer userId) {
		List<Contact> listContact=contactDAO.findProperty("userid", userId);
		List<ContactDTO> listContactDto=new ArrayList();
		for(Contact contact :listContact) {
			ContactDTO cdto=new ContactDTO();
			cdto.setContactId(contact.getContactId());
			cdto.setUserId(contact.getUserId());
			cdto.setName(contact.getName());
			cdto.setPhone(contact.getPhone());
			cdto.setEmail(contact.getEmail());
			cdto.setAddress(contact.getAddress());
			cdto.setRemark(contact.getRemark());
			listContactDto.add(cdto);
		}
		return listContactDto;
	}

	@Override
	public List<ContactDTO> findUserContact(Integer userId, String txt) {
		List<Contact> listContact=contactDAO.findUserContact(userId, txt);
		List<ContactDTO> listContactDto=new ArrayList();
		for(Contact contact :listContact) {
			ContactDTO cdto=new ContactDTO();
			cdto.setContactId(contact.getContactId());
			cdto.setUserId(contact.getUserId());
			cdto.setName(contact.getName());
			cdto.setPhone(contact.getPhone());
			cdto.setEmail(contact.getEmail());
			cdto.setAddress(contact.getAddress());
			cdto.setRemark(contact.getRemark());
			listContactDto.add(cdto);
		}
		return listContactDto;
	}

	/* (non-Javadoc)
	 * @see com.nt.service.ContactService#findById(java.lang.Integer)
	 */
	@Override
	public ContactDTO findById(Integer contactId) {
		Contact contact=contactDAO.findById(contactId);
		ContactDTO cdto=new ContactDTO();
		cdto.setContactId(contact.getContactId());
		cdto.setUserId(contact.getUserId());
		cdto.setName(contact.getName());
		cdto.setPhone(contact.getPhone());
		cdto.setEmail(contact.getEmail());
		cdto.setAddress(contact.getAddress());
		cdto.setRemark(contact.getRemark());
		return cdto;
	}

}
