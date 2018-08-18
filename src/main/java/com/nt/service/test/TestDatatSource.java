/**
 * 
 */
package com.nt.service.test;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.config.SpringRootConfig;

import oracle.jdbc.OracleDriver;

/**
 * @author abc
 *
 */
public class TestDatatSource {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int count=0;

		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds=context.getBean("ds1",DataSource.class);
		JdbcTemplate jt=new JdbcTemplate(ds);
        System.out.println(jt.getMaxRows());
        System.out.println("----------------------");
		String sql="insert into user (name,phone,email,address,loginname,password,role,loginstatus) values(?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Object[] param=new Object[] {"RR","9845678321","mdalam@gmail.com","xyz","dfg","234a1",1,0};
		 count=jt.update(sql,param);
		 System.out.println("-----------SQL Execuited--------------");
		 if(count==0)
			 System.out.println("Record is not inserted in DB "+count);
		 else
			 System.out.println("Record is inserted in DB "+count);
//		 
//		try{  
//			Class.forName("com.mysql.jdbc.Driver");  
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/capp/-db","root","root");
//			if(con!=null)
//				System.out.println("Conn found");
//			else
//				System.out.println("Conn not found");
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		System.out.println("Welcome");

		
	}

}
