
package com.nt.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Rashid
 *
 */
@Configuration
//@ComponentScan(basePackages={"com.nt"})
@Import(value= {PersistanceConfig.class,ServiceConfig.class})
public class SpringRootConfig {
	//nTODO: Services,DAO,DataSource,Email Sender or some other business layer
}
