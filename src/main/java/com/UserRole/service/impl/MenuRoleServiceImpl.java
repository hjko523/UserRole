package com.UserRole.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserRole.mapper.MenuMapper;
import com.UserRole.mapper.MenuRoleMapper;
import com.UserRole.mapper.RoleMapper;
import com.UserRole.model.MenuRole;
import com.UserRole.service.MenuRoleService;
import com.UserRole.web.UserController;

@Service
public class MenuRoleServiceImpl implements MenuRoleService{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MenuRoleMapper mrMapper;
	

	@Autowired
	private MenuMapper menuMapper;
	

	@Autowired
	private RoleMapper roleMapper;


	@Override
	public List<MenuRole> findMr() {
		
		return mrMapper.findMr();
	}
	

}
