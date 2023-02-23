package com.UserRole.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.UserRole.model.User;
import com.UserRole.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	

	@GetMapping(value="/")
	public String main(Model model) {
		
		List<User> userList = userService.findUsers();
		log.info(userList.toString());
		
		model.addAttribute("userList", userList);
		
		return "user/user_list";
	}
}