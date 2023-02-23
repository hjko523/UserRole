package com.UserRole.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UserRole.model.User;
import com.UserRole.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	

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
	public String userAdd(Model model) {
		
		
		return "user/user_add";
	}
	
	// 사용자 수정 페이지 로드
	@GetMapping("/user/edit_load/{userId}")
    public String editDataLoad( @PathVariable String id, ModelMap map) {

		log.info("사용자 정보를 가져옵니다");
       	User user = userService.findUserById(id);       // user.id로 사용자 데이터 가져오기
       	log.info("user", user);
       	
        map.addAttribute("user", user);

        return "user/user_edit";
    }
}

