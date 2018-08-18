/**
 * 
 */
package com.nt.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringRootConfig;
import com.nt.dao.ContactDAO;
import com.nt.domain.Contact;

/**
 * @author abc
 *
 */
public class TestContactDAOSave {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=context.getBean(ContactDAO.class);
		Contact cnt=new Contact();
		cnt.setUserId(1004);
		cnt.setName("RQ");
		cnt.setPhone("9952221311");
		cnt.setEmail("alammd1@gmail.com");
		cnt.setAddress("Delhi");
		cnt.setRemark("Friends");
		Integer result=contactDAO.save(cnt);
		if(result!=0)
			System.out.println("----------Data is Saved---------------------");
		else
			System.out.println("----------Data is not Saved---------------------");

	}

}
