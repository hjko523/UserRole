package com.UserRole.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserRole.mapper.UserMapper;
import com.UserRole.mapper.UserRoleMapper;
import com.UserRole.model.User;
import com.UserRole.model.UserRole;
import com.UserRole.service.UserService;
import com.UserRole.web.UserController;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	

	@Autowired
	private UserMapper userMapper;
	

	@Autowired
	private UserRoleMapper urMapper;


	
	@Override
	public List<User> findUsers() {
		return userMapper.findUsers();
	}

	@Override
	public User findUserById(String id) {	
		
		log.info("impl 진입");
		
		return userMapper.findUserById(id);
	}

	@Override
	public int addUser(User user, String roleId) {
		
		log.info("impl 진입");
		int result1 = userMapper.addUser(user);
		
		UserRole ur = new UserRole();
		ur.setUserId(user.getUserId());
		int result2 = urMapper.addUr(ur);
		
		int result;
		if((result1 == 1) && (result2 == 1))
			result = 1;
		else
			result = 0;
		
		return result;
	}

}
