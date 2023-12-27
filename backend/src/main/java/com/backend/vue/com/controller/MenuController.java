package com.backend.vue.com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.vue.com.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/com")
public class MenuController {
	@Autowired   
	//MyBatisGridService mmService;
	MenuService menuService;
	
	@PostMapping(value= "/selMenu")
	public List<Map<String, Object>> selMenu() {
		List<Map<String, Object>> result = menuService.selMenu();
        return result;
	}
}