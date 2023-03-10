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

import com.UserRole.POJO.UserPOJO;
import com.UserRole.model.Role;
import com.UserRole.model.User;
import com.UserRole.service.RoleService;
import com.UserRole.service.UserRoleService;
import com.UserRole.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService urService;



	// 사용자 목록
	@GetMapping(value={"/","/user/user_list"})
	public String main(Model model) {
		
		log.info("정보를 가져옵니다");
		List<UserPOJO> userList = userService.findUsers();
		log.info(userList.toString());
		
		model.addAttribute("userList", userList);
		
		return "user/user_list";
	}
	
	// 사용자 등록
	@GetMapping(value="/user/user_add")
	public String userAdd(ModelMap map) {
		
		 log.info("정보를 가져옵니다");
		 
		 // 역할 리스트 가져오기	
		 List<Role> roleList = roleService.findRole();     
	     map.addAttribute("roleList", roleList);	
	     
	 	 log.info(roleList.toString());
		
		return "user/user_add";
	}
	
    @PostMapping("/user/user_add")
    @ResponseBody
    public int userAdd(@ModelAttribute("add") User user, String roleId) {

        log.info("# 사용자 등록");
        log.info("user={}", user);
        log.info("role={}", roleId);
       
        int result = userService.addUser(user, roleId);
            
        return result;
    }
	
	
	// 사용자 수정 페이지 로드
	@GetMapping("/user/load_edit")
    public String editDataLoad(@RequestParam("userId") String userId, ModelMap map) {
		
	     UserPOJO user = userService.findUserById(userId);		 
		 map.addAttribute("user", user);
		 log.info(user.toString());
		 
		// 역할 리스트 가져오기	
				 List<Role> roleList = roleService.findRole();     
			     map.addAttribute("roleList", roleList);	
		 
		 return "user/user_edit";
    }
	
	// 사용자 수정
	@PostMapping("/user/user_edit")
    @ResponseBody
    public int editUser( User user, String roleId) {

        log.info("# 사용자 등록 ");
        log.info("user={}", user);
       
        int result = userService.updateUser(user, roleId);
            
        return result;
    }
	
	// 사용자 삭제
	@PostMapping("/user/user_delete")
    @ResponseBody
    public int deleteUser(String userId) {

        log.info("# 사용자 삭제 ");
        log.info("user={}", userId);
       
        int result = userService.deleteUser(userId);
            
        return result;
    }
		
	
	
	
	// 사용자 권한
	@GetMapping(value="/user/user_role")
	public String userRole(ModelMap map) {
		
		 // 역할 리스트 가져오기
		 List<Role> roleList = roleService.findRole();     
	     map.addAttribute("roleList", roleList);	
		
		return "user/user_role";
	}
	
	
	// 사용자 권한 화면
	@PostMapping(value="/user/userRole_info")    
	public String roleInfo(@RequestParam("roleId") String roleId, Model model) {
		
		log.info("# roleInfo start ============================");
		log.info("roleId={}", roleId);
		 
		List<UserPOJO> user  = userService.findUserList(roleId);
		//List<UserPOJO> noUser  = userService.findNoUserList(roleId);
		
		model.addAttribute("urList", user);
		//model.addAttribute("noList", noUser);
	 
		log.info("user={}", user);
		//log.info("noUser={}", noUser);
		 
		 
		return "user/frag_urInfo" ;
	}
	
	
	// 사용자 권한 화면
	@PostMapping(value="/user/noUserRole_info")    
	public String noRoleInfo(@RequestParam("roleId") String roleId, Model model) {		
		
		log.info("# noRoleInfo start ============================");
		log.info("roleId={}", roleId);		 
		
		List<UserPOJO> noUser  = userService.findNoUserList(roleId);		
		
		model.addAttribute("noList", noUser);	 
	
		log.info("noUser={}", noUser);
		 
		 
		return "user/frag_noUrInfo" ;
	}
	
	
	
	// 사용자 권한 수정
	@PostMapping(value="/user/change_role")    
    @ResponseBody
	public int changeRole(String userId, String roleId) {
		
		log.info("# 사용자 권한 수정 ============================");
		log.info("userId={}", userId);
		log.info("roleName={}", roleId);
		
		
		
		int result = urService.updateRole(userId, roleId);
		//log.info("result={}", result);
		
		return result;
		
	}

}

