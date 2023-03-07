package com.UserRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.UserRole.POJO.UserPOJO;
import com.UserRole.model.User;

@Mapper
public interface UserMapper {

	List<UserPOJO> findUsers();

	UserPOJO findUserById(String id);
	
	List<UserPOJO> findUserListById(List<String> id);

	int addUser(User user);
	
	int updateUser(User user);

	List<UserPOJO> findUserList(String roleId);

	
}