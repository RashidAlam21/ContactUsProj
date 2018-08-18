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
public class TestUserDAODelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=context.getBean(UserDAO.class);
		User user=new User();
		user.setUserId(1005);
		Integer result=userDAO.delete(user);
		if(result!=0)
			System.out.println("---------------Data is Deleted---------------");
		else
			System.out.println("---------------Data is not Deleted---------------");
		

	}

}
