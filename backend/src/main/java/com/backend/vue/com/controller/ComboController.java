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

import com.backend.vue.com.service.ComboService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/com")
public class ComboController {
	@Autowired   
	//MyBatisGridService mmService;
	ComboService comboService;
	
	@PostMapping(value= "/selCombo")
	public List<Map<String, Object>> selCombo(@RequestBody Map<String, String> request) {
		String groupCd = request.get("groupCd");
		
		List<Map<String, Object>> result = comboService.selCombo(groupCd);
        return result;
	}
}