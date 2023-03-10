package com.UserRole.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.UserRole.service.MenuService;
import com.UserRole.service.RoleService;
import com.UserRole.service.UserRoleService;

@Controller
public class MenuController {

	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService urService;
	
	
	@GetMapping(value="/menu/menu_role") 
	public String main() { 
		
		
		
		
		return "/menu/menu_role"; 
	}
	 
}
