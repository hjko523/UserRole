package com.UserRole.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.UserRole.model.Menu;
import com.UserRole.model.Role;
import com.UserRole.service.MenuRoleService;
import com.UserRole.service.MenuService;
import com.UserRole.service.RoleService;
import com.UserRole.service.UserRoleService;

@Controller
public class MenuController {

	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuRoleService mrService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService urService;
	
	
	@GetMapping(value="/menu/menu") 
	public String menu(ModelMap map) { 		
		
	    // menu list
		List<Menu> menu = menuService.findMenu();		
		map.addAttribute("menuList", menu);
		
		return "/menu/menu"; 
	}
	
	
	// 메뉴권한
	
	@GetMapping(value="/menu/menu_role") 
	public String menuRole(ModelMap map) { 
		
		// role list	
		List<Role> roleList = roleService.findRole();     
	    map.addAttribute("roleList", roleList);	
	    
	    // menu list
		List<Menu> menu = menuService.findMenu();		
		map.addAttribute("menuList", menu);
		
		return "/menu/menu_role"; 
	}
	 
}
