package com.UserRole.mapper;

import java.util.List;

import com.UserRole.model.MenuRole;
import com.UserRole.POJO.MenuPOJO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuRoleMapper {

	List<MenuRole> findMr();
  
}