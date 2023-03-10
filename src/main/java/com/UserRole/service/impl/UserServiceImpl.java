package com.UserRole.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserRole.POJO.UserPOJO;
import com.UserRole.mapper.RoleMapper;
import com.UserRole.mapper.UserMapper;
import com.UserRole.mapper.UserRoleMapper;
import com.UserRole.model.User;
import com.UserRole.model.UserRole;
import com.UserRole.service.UserService;
import com.UserRole.web.UserController;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	

	@Autowired
	private UserMapper userMapper;
	

	@Autowired
	private RoleMapper roleMapper;
	

	@Autowired
	private UserRoleMapper urMapper;


	
	@Override
	public List<UserPOJO> findUsers() {			
		
		return userMapper.findUsers();
	}

	@Override
	public UserPOJO findUserById(String id) {	
		
		log.info("impl 진입");
		
		return userMapper.findUserById(id);
	}

	// 사용자 등록
	@Override
	public int addUser(User user, String roleId) {
		
		log.info("impl 진입");
		
		// user 데이터 insert		
		//user.setCreateTime(Calendar.getInstance().getTime()); // 생성시간
		int result1 = userMapper.addUser(user);
		
		// user_role 데이터 insert
		UserRole ur = new UserRole();
		ur.setUserId(user.getUserId());
		ur.setRoleId(roleId);
		int result2 = urMapper.addUr(ur);
		
		int result;
		if((result1 == 1) && (result2 == 1))
			result = 1;
		else
			result = 0;
		
		log.info("result", result);
		
		return result;
	}
	
	// 사용자 수정
	@Override
	public int updateUser(User user, String roleId) {
		
		log.info("Impl : updateUser");
		log.info("user={}", user);
		
		// 기존 user정보 가져오기
		UserPOJO u = userMapper.findUserById(user.getUserId());  
		log.info("기존 ={}", u);
              
		log.info("기존 role ={}", u.getRoleName());
		log.info("new role ={}", roleId);
        // 기존 user와 update user의 role이 같지 않을경우 user_role과 user update  
		int result = 0;
		
		if(!u.getRoleName().equals(roleId)) {
			
			UserRole ur = new UserRole();
			ur.setUserId(user.getUserId());
			ur.setRoleId(roleId);
			
			result = urMapper.updateUr(ur);
			
			// user_role update가 되면 user도 update
			if(result == 1) {
				userMapper.updateUser(user);
				log.info("result={}", result);
				
				return result;
				
			} else {
				
				log.info("result={}", result);
				return result;
				
			}
			
		} else {	// 아닐경우 user만 업데이트
			result = userMapper.updateUser(user);
		}
		
		//user.setModifyTime(Calendar.getInstance().getTime()); // 수정시간
		
		
		log.info("result={}", result);
		
		return result;
	}



	@Override
	public List<UserPOJO> findUserList(String roleId) {
		
		return userMapper.findUserList(roleId);
	}

	@Override
	public List<UserPOJO> findNoUserList(String roleId) {
		
		return userMapper.findNoUserList(roleId);
	}
	
	@Override
	public int deleteUser(String userId) {
		
		return userMapper.deleteUser(userId);
	}



}
