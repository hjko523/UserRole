package com.UserRole.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.UserRole.model.User;
import com.UserRole.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@GetMapping(value="/")
	public String main(ModelMap map) {
		
		List<User> userList = userService.findUsers();
		
		map.put("userList", userList);
		
		return "user/user_list";
	}
}