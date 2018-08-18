/**
 * 
 */
package com.nt.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringRootConfig;
import com.nt.dao.UserDAO;
import com.nt.domain.User;

/**
 * @author abc
 *
 */
public class TestUserDAOSave {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO=context.getBean(UserDAO.class);
		User user=new User();
		//user.setUserId(1);
		user.setName("Aamir");
		user.setPhone("9923425891");
		user.setEmail("amir@gmail.com");
		user.setAddress("Hyd");
		user.setLoginName("amir");
		user.setPassword("amir");
		user.setRole(1);
		user.setLoginStatus(2);
		Integer result =userDAO.save(user);
		if(result!=0)
			System.out.println("----------Data Saved---------------------");
		else
			System.out.println("----------Data Not Saved---------------------");

	}

}
