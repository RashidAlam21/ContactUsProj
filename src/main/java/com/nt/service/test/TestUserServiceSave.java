/**
 * 
 */
package com.nt.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringRootConfig;
import com.nt.dto.UserDTO;
import com.nt.service.UserService;

/**
 * @author abc
 *
 */
public class TestUserServiceSave {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService=context.getBean(UserService.class);
		UserDTO user=new UserDTO();
		//	user.setUserId(1);
		user.setName("Najish");
		user.setPhone("960092313");
		user.setEmail("najish.in@gmail.com");
		user.setAddress("Hyderabad");
		user.setLoginName("shaad");
		user.setPassword("shaad");
		user.setRole(userService.ROLE_ADMIN);
		user.setLoginStatus(userService.LOGIN_STATUS_ACTIVE);
		Integer result =userService.registration(user);
		if(result!=0)
			System.out.println("----------User Registration is successfully---------------------");
		else
			System.out.println("----------User Registration is not successfully---------------------");

	}

}
