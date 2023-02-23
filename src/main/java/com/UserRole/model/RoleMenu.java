package com.UserRole.model;

import lombok.Data;

@Data
public class RoleMenu {
	
	private String roleMenuId;
	
	private String roleId;
	
	private String menuId;
	
	private String menuName;
	
	private Integer read;
	
	private Integer create;
	
	private Integer update;
	
	private Integer delete;
	
	private Integer state;
	
	
}
