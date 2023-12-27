package com.backend.vue.com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.vue.com.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseBody
@RestController
@Controller
@RequestMapping("/com")
public class LoginController {
	@Autowired   
	LoginService loginService;
	
	@PostMapping(value= "/selLogin")
	public List<Map<String, Object>> selLogin(@RequestBody Map<String, String> request,
            HttpServletRequest httpRequest) {
		String username = request.get("username");
		String password = request.get("password");
		
		// Assuming that loginService.selLogin returns the list of menus based on username and password
		List<Map<String, Object>> loginList = loginService.selLogin(username, password);
		
		// Store the username in the session
		HttpSession session = httpRequest.getSession();
		session.setAttribute("username", username);
		
		return loginList;
	}
	
	@PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("Logged out successfully");
    }
}
