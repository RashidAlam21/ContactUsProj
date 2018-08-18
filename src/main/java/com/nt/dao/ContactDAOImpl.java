/**
 * 
 */
package com.nt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.nt.domain.Contact;
import com.nt.domain.User;
import com.nt.dto.ContactDTO;
import com.nt.rm.ContactRowMapper;

/**
 * @author abc
 *
 */
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

	/* (non-Javadoc)
	 * @see com.nt.dao.ContactDAO#save(com.nt.domain.Contact)
	 */
	public int save(Contact cnt) {
		String sql = "INSERT INTO CONTACT(contactid,userid,name,phone,email,address,remark)"
				+ " VALUES(:contactid,:userid,:name,:phone,:email,:address,:remark)";
		
		Map map = new HashMap();
		map.put("contactid",cnt.getContactId());
		map.put("userid",cnt.getUserId());
		map.put("name", cnt.getName());
		map.put("phone", cnt.getPhone());
		map.put("email", cnt.getEmail());
		map.put("address", cnt.getAddress());
		map.put("remark", cnt.getRemark());
		
		SqlParameterSource ps=new MapSqlParameterSource(map);// Source of the value from NamedParameter....
		KeyHolder kh=new GeneratedKeyHolder();
		Integer in = getNamedParameterJdbcTemplate().update(sql, ps, kh);
		System.out.println(in);
		cnt.setContactId(kh.getKey().intValue());
		//System.out.print(cnt.setContactId(kh.getKey().intValue()));
		return in;
	}

	/* (non-Javadoc)
	 * @see com.nt.dao.ContactDAO#update(com.nt.domain.Contact)
	 */
	public int update(Contact cnt) {
		String sql = "UPDATE CONTACT SET name=:name,phone=:phone,email=:email,address=:address,remark=:remark "
				     +" WHERE contactid=:contactid";
				
		
		Map map = new HashMap();
		map.put("contactid",cnt.getContactId());
		map.put("name", cnt.getName());
		map.put("phone", cnt.getPhone());
		map.put("email", cnt.getEmail());
		map.put("address", cnt.getAddress());
		map.put("remark", cnt.getRemark());
		return getNamedParameterJdbcTemplate().update(sql, map);	
	}
	public int delete(Contact cnt) {
		return this.deleteById(cnt.getContactId());
	}
	public int deleteById(Integer contactId) {
		String sql="delete from contact where contactId=?";
		return getJdbcTemplate().update(sql, contactId);		
	}
	public Contact findById(Integer contactId) {
		String sql="SELECT contactid,userid,name,phone,email,address,remark"
				+" from contact where contactid=?";
		
		return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(),contactId);
	}
	public List<Contact> findAll() {
		String sql="SELECT contactid,userid,name,phone,email,address,remark from contact";
		return getJdbcTemplate().query(sql,new ContactRowMapper());
	}
	public List<Contact> findProperty(String propName, Object propValue) {
		String sql="SELECT contactid,userid,name,phone,email,address,remark from contact"
	    + " where "+propName+" =?";
		return getJdbcTemplate().query(sql,new ContactRowMapper(),propValue);
	}

	/* (non-Javadoc)
	 * @see com.nt.dao.ContactDAO#findUserContact(java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		String sql="SELECT contactid,userid,name,phone,email,address,remark from contact where userid=? AND (name LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
		return getJdbcTemplate().query(sql,new ContactRowMapper(),userId);
	}
}
