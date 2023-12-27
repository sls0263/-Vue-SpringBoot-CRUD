package com.backend.vue.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.backend.vue.com.dao.LoginDao;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
 
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selLogin(String username, String password) {
	    return loginDao.selLogin(username, password);
	}
	
	// 권한체크(로그인 여부 확인)
	public List<Map<String, Object>> checkLoginInfo() {
        // Retrieve the username from the session
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        String username = (String) session.getAttribute("username");

        // 권한체크
        List<Map<String, Object>> loginInfo = new ArrayList<>();

        loginInfo = sqlSessionTemplate.selectList("LoginMapper.selLoginId", username);

        return loginInfo;
    }
}