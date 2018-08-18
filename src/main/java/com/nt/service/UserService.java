/**
 * 
 */
package com.nt.service;

import java.util.List;

import com.nt.domain.Contact;
import com.nt.domain.User;
import com.nt.dto.UserDTO;
import com.nt.exception.UserBlockedException;

/**
 * @author abc
 *
 */
public interface UserService {
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;
	
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	/**
	 * This method handles User registration task.
	 * @param user the new user details user object.
	 */
	public int registration(UserDTO userDto);
	/**
	 * This method handles login operation(authentication) using given by credentials.
	 * it return user object when success and null when failed. when user account is blocked 
	 * and exception will be thrown by this method 
	 * @param loginName
	 * @param password
	 * @return
	 * @throws com.nt.exception.UserBlockedException when user account is blocked
	 */
	public User login(String loginName,String password)throws UserBlockedException;
	/**
	 * Call this method to get list of registered users.
	 * @return
	 */
	public List<UserDTO> getUserList();
	/**
	 * This method change the user loginstatus for details pass as argument..
	 * @param userId
	 * @param loginStatus
	 */
	public int changeLoginStatus(Integer userId,Integer loginStatus);
	public Boolean isUserNameExist(String username);
}
