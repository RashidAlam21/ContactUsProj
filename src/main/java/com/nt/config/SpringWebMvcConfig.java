/**
 * 
 */
package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

/**
 * @author Rashid
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.nt"})
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter{
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		//super.addResourceHandlers(registry);
	}
	@Bean
	public ViewResolver xmlViewResolver() {
		XmlViewResolver xmlvr=new XmlViewResolver();
		//xmlvr.setLocation("/WEB-INF/Spring-views.xml");
		//String l="/WEB-INF/spring-views.xml";
		Resource location=new ClassPathResource("/view/spring-view.xml");
		//esource location=/WEB-INF/spring-views.xml;
		xmlvr.setLocation(location);
		xmlvr.setOrder(0);
		return xmlvr;
	}
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver ivr=new InternalResourceViewResolver();
		//ivr.setViewClass(JstlView.class);
		ivr.setPrefix("/WEB-INF/views/");
		ivr.setSuffix(".jsp");
		return ivr;
	}
}
