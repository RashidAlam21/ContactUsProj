/**
 * 
 */
package com.nt.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.SpringRootConfig;
import com.nt.dao.ContactDAO;
import com.nt.domain.Contact;

/**
 * @author abc
 *
 */
public class TestContactDAOFindSingleRecord {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=context.getBean(ContactDAO.class);
		Contact cnt=contactDAO.findById(1);
		System.out.println("--------------------cnt Details :--------------------");
		System.out.println();
		System.out.println("cntId :- "+cnt.getContactId());
		System.out.println("cntId :- "+cnt.getUserId());
		System.out.println("Name :- "+cnt.getName());
		System.out.println("Phone :- "+cnt.getPhone());
		System.out.println("Email :- "+cnt.getEmail());
		System.out.println("Address :- "+cnt.getAddress());
		System.out.println("LoginName :- "+cnt.getRemark());
		
		

	}

}
