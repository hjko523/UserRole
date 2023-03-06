package com.UserRole.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UserRole.model.Role;

@Service
public interface RoleService {

    List<Role> findRole();
    
    Role findRoleById(String roleId);
}