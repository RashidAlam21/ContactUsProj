/**
 * 
 */
package com.nt.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author abc
 *
 */
@Controller
public class TestController {
	@RequestMapping("/test/hello")
	public String helloWorld() {
		return "hello";
	}
	@RequestMapping("/test/ajax_test")
	public String testWithAjax() {
		return "test";
	}
	@ResponseBody
	@RequestMapping("/test/get_time")
	public String getServerTime() {
		System.out.println("----------getServerTime()`------------");
		Date d=new Date();
		return d.toString();
	}
}
