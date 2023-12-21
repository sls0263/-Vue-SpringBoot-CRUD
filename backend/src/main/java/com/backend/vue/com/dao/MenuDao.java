package com.backend.vue.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selMenu() {
		List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
		
		menuList = sqlSessionTemplate.selectList("MenuMapper.selMenu");
		return menuList;
	}
}