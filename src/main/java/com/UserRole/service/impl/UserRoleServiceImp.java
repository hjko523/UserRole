package com.UserRole.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserRole.mapper.UserRoleMapper;
import com.UserRole.service.UserRoleService;
import com.UserRole.web.UserController;

@Service
public class UserRoleServiceImp implements UserRoleService{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRoleMapper urMapper;
	

	@Override
	public int updateRole(String userId, String roleId) {
		
		return urMapper.updateUr(userId, roleId);
	}

	

}
