package com.backend.vue.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.vue.com.dao.MenuDao;

@Service
public class MenuService {
 
	@Autowired
	private MenuDao menuDao;
	
	public List<Map<String, Object>> selMenu() {
		return menuDao.selMenu();
	}
}