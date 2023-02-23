package com.UserRole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserRole.mapper.UserMapper;
import com.UserRole.model.User;
import com.UserRole.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findUsers() {
		return userMapper.findUsers();
	}

}
