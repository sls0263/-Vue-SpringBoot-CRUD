package com.backend.vue.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selLogin(String username, String password) {
		Map<String, Object> params = new HashMap<>();
	    params.put("username", username);
	    params.put("password", password);

	    List<Map<String, Object>> loginInfo = new ArrayList<>();

	    loginInfo = sqlSessionTemplate.selectList("LoginMapper.selLogin", params);
	    
	    return loginInfo;
	}
}