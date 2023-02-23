package com.UserRole.service;

import java.util.List;

import com.UserRole.model.User;

public interface UserService {
		
	List<User> findUsers();

	User findUserById(String id);
}