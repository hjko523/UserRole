package com.UserRole.service;

import java.util.List;

import com.UserRole.POJO.UserPOJO;
import com.UserRole.model.User;

public interface UserService {
		
	List<UserPOJO> findUsers();

	UserPOJO findUserById(String id);

	int addUser(User user, String roleId);


	int updateUser(User user, String roleId);
}