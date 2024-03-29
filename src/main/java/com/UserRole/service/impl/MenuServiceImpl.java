package com.UserRole.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserRole.mapper.MenuMapper;
import com.UserRole.mapper.RoleMapper;
import com.UserRole.model.Menu;
import com.UserRole.service.MenuService;
import com.UserRole.web.UserController;

@Service
public class MenuServiceImpl implements MenuService{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	

	@Autowired
	private MenuMapper menuMapper;
	

	@Autowired
	private RoleMapper roleMapper;


	@Override
	public List<Menu> findMenu() {
		
		return menuMapper.findMenu();
	}


	@Override
	public List<String> findCate() {
	
		return menuMapper.findCate();
	}


	@Override
	public List<Menu> findCateList(String category) {
		
		return  menuMapper.findCateList(category);
	}


	@Override
	public int updateCateShow(String menuId) {
		
		log.info("# update show");
		log.info("menuId={}", menuId);
		
		// 선택한 메뉴 정보 가져오기
		//Menu menu = menuMapper.findMenuList(menuId);
		
		int result = menuMapper.updateCateShow(menuId);
		
		
		return result;
	}
	

}
