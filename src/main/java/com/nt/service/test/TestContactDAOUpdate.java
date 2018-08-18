 /**
 * 
 */
package com.nt.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringRootConfig;
import com.nt.dao.ContactDAO;
import com.nt.domain.Contact;
import com.nt.domain.User;

/**
 * @author abc
 *
 */
public class TestContactDAOUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=context.getBean(ContactDAO.class);
		Contact cnt=new Contact();
		cnt.setContactId(3);
		cnt.setName("RM");
		cnt.setPhone("9990259848");
		cnt.setEmail("alam12@gmail.com");
		cnt.setAddress("Hyderabad");
		cnt.setRemark("Student");
		Integer result=contactDAO.update(cnt);
		if(result!=0)
			System.out.println("---------------Data is Updated---------------");
		else
			System.out.println("---------------Data is not Updated---------------");
		

	}

}
