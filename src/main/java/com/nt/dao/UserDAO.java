/**
 * 
 */
package com.nt.dao;

import java.util.List;

import com.nt.domain.User;

/**
 * @author abc
 *
 */
public interface UserDAO {
	public int save(User user);
	public int update(User user);
	public int delete(User user);
	public int delete(Integer userId);
	public User findById(Integer userId);
	public List<User> findAll();
	public List<User> findProperty(String propName,Object propValue);
}
