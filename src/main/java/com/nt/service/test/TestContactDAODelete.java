 /**
 * 
 */
package com.nt.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringRootConfig;
import com.nt.dao.ContactDAO;
import com.nt.dao.UserDAO;
import com.nt.domain.Contact;
import com.nt.domain.User;

/**
 * @author abc
 *
 */
public class TestContactDAODelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=context.getBean(ContactDAO.class);
		Contact cnt=new Contact();
		cnt.setContactId(11);
		Integer result=contactDAO.delete(cnt);
		if(result!=0)
			System.out.println("---------------Data is Deleted---------------");
		else
			System.out.println("---------------Data is not Deleted---------------");
		
		

	}

}
