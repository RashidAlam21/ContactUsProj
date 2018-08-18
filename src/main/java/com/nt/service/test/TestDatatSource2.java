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
public class TestDatatSource2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int count=0;

		ApplicationContext context=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds=context.getBean("ds1",DataSource.class);
		JdbcTemplate jt=new JdbcTemplate(ds);
     //System.out.println(jt.getMaxRows());
     System.out.println("----------------------");
		String sql="insert into users1 (user_id,name,phone,email,address,login_name,password,role,login_status) values(?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Object[] param=new Object[] {1001,"RR","9845678321","mdalam@gmail.com","xyz","dfg","234a1",1,0};
		 count=jt.update(sql,param);
		 System.out.println("-----------SQL Execuited--------------");
		 if(count==0)
			 System.out.println("Record is not inserted in DB "+count);
		 else
			 System.out.println("Record is inserted in DB "+count);
		System.out.println("Welcome");

		
	}

}
