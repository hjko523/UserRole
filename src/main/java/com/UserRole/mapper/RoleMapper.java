package com.UserRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.UserRole.model.Role;

@Mapper
public interface RoleMapper {

	List<Role> findRole();
	
	Role findByRoleId(String roleId);

}