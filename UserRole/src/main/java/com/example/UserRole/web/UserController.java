package com.example.UserRole.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.UserRole.model.User;
import com.example.UserRole.service.UserService;

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