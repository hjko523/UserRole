package com.UserRole.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UserRole.model.MenuRole;

@Service
public interface MenuRoleService {

    List<MenuRole> findMr();
    
    
}