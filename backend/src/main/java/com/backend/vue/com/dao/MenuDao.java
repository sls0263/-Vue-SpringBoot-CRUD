package com.backend.vue.com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.vue.com.service.LoginService;

@Repository
public class MenuDao {

	@Autowired
    private LoginService loginService;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selMenu() {
		// 권한체크
		List<Map<String, Object>> loginInfo = loginService.checkLoginInfo();

        if (loginInfo.size() > 0) {
            List<Map<String, Object>> menuList = new ArrayList<>();

            menuList = sqlSessionTemplate.selectList("MenuMapper.selMenu");
            return menuList;
        } else {
            return new ArrayList<>();
        }
    }
}