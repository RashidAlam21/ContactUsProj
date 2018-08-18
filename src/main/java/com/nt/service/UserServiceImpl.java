package com.nt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nt.dao.BaseDAO;
import com.nt.dao.UserDAO;
import com.nt.domain.User;
import com.nt.dto.UserDTO;
import com.nt.exception.UserBlockedException;
import com.nt.rm.UserRowMapper;

/**
 * @author Rashid
 *
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public int registration(UserDTO userDto) {
		Integer status=0;
		User user =new User();
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setPhone(userDto.getPhone());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setLoginName(userDto.getLoginName());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setLoginStatus(userDto.getLoginStatus());
		status=userDAO.save(user);
		return status;
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql="SELECT userid,name,phone,email,address,role,loginstatus,loginname,password from user"
				+" where loginname =:lnm AND password =:pwd ";
		Map map=new HashMap();
		map.put("lnm",loginName);
		map.put("pwd",password);
		try {
			System.out.println(map);
			User user=getNamedParameterJdbcTemplate().queryForObject(sql,map,new UserRowMapper());
			System.out.println(user);
			if(user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your Account has been blocked !Plz contact to Admin...");
			}
			return user;
		}catch(EmptyResultDataAccessException erdac) {
			return null;
		}
	}


	@Override
	public List<UserDTO> getUserList() {
		List<User> listuser=userDAO.findProperty("role", UserService.ROLE_USER);
		List<UserDTO> listUserDTO=new ArrayList();
		for(User user:listuser) {
			UserDTO userDTO=new UserDTO();
			userDTO.setUserId(user.getUserId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setPhone(user.getPhone());
			userDTO.setAddress(user.getAddress());
			userDTO.setLoginName(user.getLoginName());
			userDTO.setPassword(user.getPassword());
			userDTO.setRole(user.getRole());
			userDTO.setLoginStatus(user.getLoginStatus());
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

	@Override
	public int changeLoginStatus(Integer userId, Integer loginStatus) {
		System.out.println("------------------------------");
		System.out.println(userId+"------"+loginStatus);
		String sql="UPDATE user SET loginstatus=:lst WHERE userid=:uid";
		Map m=new HashMap();
		m.put("uid", userId);
		m.put("lst",loginStatus);
		System.out.println("---------------------------");
		System.out.println(m);
		int flag=getNamedParameterJdbcTemplate().update(sql, m);
		System.out.println(flag+" Service");
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.nt.service.UserService#isUserNameExist(java.lang.String)
	 */
	@Override
	public Boolean isUserNameExist(String username) {
		System.out.println("username service "+username);
		String sql="SELECT COUNT(loginname) FROM user WHERE loginname=?";
		Integer count=getJdbcTemplate().queryForObject(sql, new String[] {username},Integer.class);
		System.out.println("count "+count);
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}

}
