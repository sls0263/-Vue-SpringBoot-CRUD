package com.backend.vue.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.vue.com.dao.ComboDao;

@Service
public class ComboService {
 
	@Autowired
	private ComboDao comboDao;
	
	public List<Map<String, Object>> selCombo(String groupCd) {
		return comboDao.selCombo(groupCd);
	}
}