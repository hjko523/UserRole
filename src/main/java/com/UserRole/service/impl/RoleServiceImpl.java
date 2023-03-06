package com.UserRole.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserRole.mapper.RoleMapper;
import com.UserRole.model.Role;
import com.UserRole.service.RoleService;
import com.UserRole.web.UserController;

@Service
public class RoleServiceImpl implements RoleService{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	

	@Autowired
	private RoleMapper roleMapper;


	@Override
	public List<Role> findRole() {
		
		return roleMapper.findRole();
	}


	@Override
	public Role findRoleById(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleById(roleId);
	}
	


}
