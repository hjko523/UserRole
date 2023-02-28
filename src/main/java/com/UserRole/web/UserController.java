package com.UserRole.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.UserRole.model.Role;
import com.UserRole.model.User;
import com.UserRole.service.RoleService;
import com.UserRole.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;


	// 사용자 목록
	@GetMapping(value={"/","/user/user_list"})
	public String main(Model model) {
		
		List<User> userList = userService.findUsers();
		log.info(userList.toString());
		
		model.addAttribute("userList", userList);
		
		return "user/user_list";
	}
	
	// 사용자 등록
	@GetMapping(value="/user/user_add")
	public String userAdd(ModelMap map) {
		
		 log.info("정보를 가져옵니다");
		 List<Role> roleList = roleService.findRole();     // role select list
	     map.addAttribute("roleList", roleList);	
	 	 log.info(roleList.toString());
		
		return "user/user_add";
	}
	
    @PostMapping("/user/user_add")
    @ResponseBody
    public int userAdd(@ModelAttribute("add") User user, String roleId) {

        log.info("# 사용자 등록 페이지로 이동");
        log.info("user={}", user);
       
        int result = userService.addUser(user, roleId);
    
        return result;
    }
	
	
	// 사용자 수정 페이지 로드
	@GetMapping("/user/load_edit")
    public String editDataLoad(@RequestParam("userId") String userId, ModelMap map) {
		
	     User user = userService.findUserById(userId);		 
		 map.addAttribute("user", user);
			log.info(user.toString());
		 
		 return "user/user_edit";
    }
}

