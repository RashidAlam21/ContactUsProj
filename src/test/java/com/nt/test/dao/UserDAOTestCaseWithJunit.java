/**
 * 
 */
package com.nt.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nt.config.SpringRootConfig;
import com.nt.dao.UserDAO;
import com.nt.domain.User;
import com.nt.service.UserService;

/**
 * @author abc
 *
 */
@ContextConfiguration(classes=SpringRootConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTestCaseWithJunit {
	@Autowired
	private UserDAO userDAO;
	private JdbcTemplate jt=Mockito.mock(JdbcTemplate.class);
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	//@Ignore
	public void saveUserTest() {
		User user=new User();
		user.setUserId(1001);
		user.setName("Mehtab");
		user.setPhone("9902932812");
		user.setEmail("mehtab12@gmail.com");
		user.setLoginName("mehtab");
		//assertNotEquals("rashid",user.setLoginName("rashid"));
		user.setPassword("alam");
		user.setRole(UserService.ROLE_USER);
		user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		//assertNotNull("User is not null", userDAO.save(user));
		assertEquals("User Exist",1, userDAO.save(user));
	}
	@Test
	@Ignore
	public void saveUserTest1() {
		User user=new User();
		user.setName("Najish");
		user.setPhone("912939434");
		user.setEmail("najish21@gmail.com");
		user.setLoginName("najish");
		user.setPassword("shaad");
		user.setRole(UserService.ROLE_USER);
		user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		assertEquals("User Exist",1, userDAO.save(user));
	}
	@Test
	public void updateUserTest() {
		User user=new User();
		user.setUserId(1005);
		user.setName("TT");
		user.setPhone("9990259849");
		user.setEmail("mno12@gmail.com");
		user.setAddress("Begumpet");
		user.setRole(1);
		user.setLoginStatus(1);
		//Integer result=userDAO.update(user);
		assertNotEquals("User not updated", 1, userDAO.update(user));
	}
	@Test
	public void delete() {
		assertEquals("User not Deleted",0, userDAO.delete(1005));
	}
	@Test
	public void findUserByIdTest() {
		
	}

}
