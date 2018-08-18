/**
 * 
 */
package com.nt.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.domain.User;

/**
 * @author abc
 *
 */
public class UserRowMapper implements RowMapper<User>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public User mapRow(ResultSet rs, int pos) throws SQLException {
		User user=new User();
		user.setUserId(rs.getInt("userid"));
		user.setName(rs.getString("name"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setLoginName(rs.getString("loginname"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getInt("role"));
		user.setLoginStatus(rs.getInt("loginstatus"));
		return user;
	}

}
