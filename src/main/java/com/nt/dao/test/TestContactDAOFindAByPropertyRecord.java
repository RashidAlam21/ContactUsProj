/**
 * 
 */
package com.nt.dao.test;

import java.util.List;
import java.util.function.Consumer;

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
public class TestContactDAOFindAByPropertyRecord {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO=context.getBean(ContactDAO.class);
		//Contact cnt=new Contact();
		List<Contact> cnt=contactDAO.findProperty("remark","student");
		System.out.println("--------------------Contact Details :--------------------");
		System.out.println();
		
//		System.out.println("userId :- "+((User) user).getUserId());
//		System.out.println("Name :- "+user.getName());
//		System.out.println("Phone :- "+user.getPhone());
//		System.out.println("Email :- "+user.getEmail());
//		System.out.println("Address :- "+user.getAddress());
//		System.out.println("LoginName :- "+user.getLoginName());
//		System.out.println("Role :- "+user.getRole());
//		System.out.println("LoginStatus :- "+user.getLoginStatus());
		cnt.forEach((Contact c)-> {
			System.out.println(c.getContactId()+"\t"+c.getUserId()+"\t"+c.getName()+"\t"+c.getPhone()+"\t"+c.getEmail()+"\t"+c.getAddress()+"\t"+c.getRemark());
		
	});

	}

}
