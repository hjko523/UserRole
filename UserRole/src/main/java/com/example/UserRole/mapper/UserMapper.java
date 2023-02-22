package com.example.UserRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.UserRole.model.User;

@Mapper
public interface UserMapper {

	List<User> findUsers();
}