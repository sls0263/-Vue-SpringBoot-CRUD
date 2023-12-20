package com.backend.vue.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComboDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selCombo(String groupCd) {
		List<Map<String, Object>> comboList = new ArrayList<Map<String, Object>>();
		
		comboList = sqlSessionTemplate.selectList("ComboMapper.selCombo", groupCd);
		return comboList;
	}
}