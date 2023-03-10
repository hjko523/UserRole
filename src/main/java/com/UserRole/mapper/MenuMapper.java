package com.UserRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.UserRole.model.Menu;

@Mapper
public interface MenuMapper {

	List<Menu> findMenu();
  

}