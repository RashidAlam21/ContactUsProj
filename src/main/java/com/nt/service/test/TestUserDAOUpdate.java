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
public class TestUserDAOUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=context.getBean(UserDAO.class);
		User user=new User();
		user.setUserId(1005);
		user.setName("TT");
		user.setPhone("9990259849");
		user.setEmail("mno12@gmail.com");
		user.setAddress("Begumpet");
		user.setRole(1);
		user.setLoginStatus(1);
		Integer result=userDAO.update(user);
		if(result!=0)
			System.out.println("---------------Data is Updated---------------");
		else
			System.out.println("----------Data is not updated---------------------");

	}

}
