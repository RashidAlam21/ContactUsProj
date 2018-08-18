/**
 * 
 */
package com.nt.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rashid
 *
 */
@Configuration
@ComponentScan(basePackages= {"com.nt.dao"})
public class PersistanceConfig {
	@Bean(name="ds1")
	public BasicDataSource getDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/capp/-db");
		//ds.setUrl(","root","root");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		//ds.setValidationQuery("INSERT 1");
		ds.setDefaultAutoCommit(true);
		return ds;
	}
}
