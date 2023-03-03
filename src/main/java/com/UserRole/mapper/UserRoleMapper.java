package com.UserRole.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.UserRole.model.UserRole;

@Mapper
public interface UserRoleMapper {

	int addUr(UserRole ur);
	
	int updateUr(UserRole ur);
    
	
}