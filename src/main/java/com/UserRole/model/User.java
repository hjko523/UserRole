package com.UserRole.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	private String userId;

	
	private String username;
	
	private String department;
	
	private String email;
	
	private String mobile;
	
	private String state;
	
	private String lastLoginTime;
	
	private Date createTime;
	
	private Date modifyTime;
	
	private Date roleName;
	
}
