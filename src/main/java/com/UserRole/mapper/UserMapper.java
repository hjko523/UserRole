package com.UserRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.UserRole.model.User;

@Mapper
public interface UserMapper {

	List<User> findUsers();

	User findUserById(String id);

	int addUser(User user);
}