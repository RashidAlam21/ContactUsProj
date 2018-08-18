/**
 * 
 */
package com.nt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.command.LoginCommand;
import com.nt.command.UserCommand;
import com.nt.domain.User;
import com.nt.dto.UserDTO;
import com.nt.exception.UserBlockedException;
import com.nt.service.UserService;

/**
 * @author Md Rashid Alam 
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value= {"/","/index"})
	public String index(Model model) {
		model.addAttribute("command", new LoginCommand());  
		return "index";
	}
	@RequestMapping(value= {"/login"},method=RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command")LoginCommand cmd,Model m,HttpSession session) {
		 try {
			User loggedInUser=userService.login(cmd.getLoginName(), cmd.getPassword());
			if(loggedInUser==null) {
				/**
				 * Failed
				 * Add error message and go back to login-form
				 */
				m.addAttribute("err", "Login Failed! Plz Enter Valid Crendentials.");
				return "index";
			}
			else {
				//Success
				//Check the role and it direct to a appropriate dashboard 
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					//TODO: add user details in session (assign to session in logged in user)
					addUserInSession(loggedInUser, session);
					return "redirect:admin/dashboard";	
				}else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
					//TODO: add user details in session (assign to session in logged in user)
					addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				}else {
					/**
					 * Add error message and go back to login-form
					 */
					m.addAttribute("err", "Invalid User ROLE.");
					return "index";
				}
			}
		} catch (UserBlockedException e) {
			/**
			 * Add error message and go back to login-form
			 */
			m.addAttribute("err", e.getMessage());
			return "index";
		}
	}

	@RequestMapping(value= {"/logout"})
	public String logout(HttpSession session) {
		session.invalidate();  
		return "redirect:index?act=lo";
	}
	@RequestMapping(value= {"/user/dashboard"})
	public String userDashBorard() {
		return "user_dashboard";
	}
	@RequestMapping(value= {"/admin/dashboard"})
	public String adminDashBoard() {
		return "admin_dashboard";
	}
	@RequestMapping(value="/reg_form")
	public String registrationForm(Model m) {
		UserCommand ucmd=new UserCommand();
		m.addAttribute("command", ucmd);
		return "reg_form";
	}
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("command")UserCommand ucmd,Model m) {
		try {
			UserDTO udto=new UserDTO();
			udto.setUserId(ucmd.getUserId());
			udto.setName(ucmd.getName());
			udto.setPhone(ucmd.getPhone());
			udto.setEmail(ucmd.getEmail());
			udto.setAddress(ucmd.getAddress());
			udto.setLoginName(ucmd.getLoginName());
			udto.setPassword(ucmd.getPassword());
			udto.setRole(UserService.ROLE_ADMIN);
			udto.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			Integer status=userService.registration(udto);
			m.addAttribute("status", status);
			return "redirect:index?act=reg";
		}catch (DuplicateKeyException dke) {
			dke.printStackTrace();
			m.addAttribute("err", "Username is already registered!Plz select another username ");
			return "reg_form";
		}
	}
	@GetMapping(value="/admin/users")
	public String getusers(Model m) {
		m.addAttribute("userlist", userService.getUserList());
		return "users";
	}
	
	@RequestMapping(value="/admin/change_status")
	@ResponseBody
	public String changeLoginStatus(@RequestParam Integer  userId ,@RequestParam Integer loginStatus) {
		try {
			System.out.println(userId+"----"+loginStatus);
		int flag=	userService.changeLoginStatus(userId, loginStatus);
		System.out.println(flag);
			return " SUCCESS : Status changed";
		}catch(Exception e) {
			e.printStackTrace();
			return "ERROR : Unable to changed status"; 
		}
	}
	@RequestMapping(value="/check_user_avail")
	@ResponseBody
	public String checkUserAvailability(@RequestParam String username) {
		System.out.println("username "+username);
		if(userService.isUserNameExist(username))
			return "This username is already exist, Plz ! choose another name";
		else
		    return "Yes! you can take this";
	}
	private void addUserInSession(User u,HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}
}
