/**
 * 
 */
package com.nt.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringRootConfig;
import com.nt.dao.UserDAO;
import com.nt.domain.User;

/**
 * @author abc
 *
 */
public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=context.getBean(UserDAO.class);
		User user=userDAO.findById(1002);
		System.out.println("--------------------User Details :--------------------");
		System.out.println();
		System.out.println("userId :- "+user.getUserId());
		System.out.println("Name :- "+user.getName());
		System.out.println("Phone :- "+user.getPhone());
		System.out.println("Email :- "+user.getEmail());
		System.out.println("Address :- "+user.getAddress());
		System.out.println("LoginName :- "+user.getLoginName());
		System.out.println("Role :- "+user.getRole());
		System.out.println("LoginStatus :- "+user.getLoginStatus());
		

	}

}
