package com.UserRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.UserRole.model.MenuRole;

@Mapper
public interface MenuRoleMapper {

	List<MenuRole> findMr();
  
}