package com.UserRole.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UserRole.model.Menu;

@Service
public interface MenuService {

    List<Menu> findMenu();
    
    
}