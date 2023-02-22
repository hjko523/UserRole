package com.example.UserRole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserRole.mapper.UserMapper;
import com.example.UserRole.model.User;
import com.example.UserRole.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findUsers() {
		return userMapper.findUsers();
	}

}
