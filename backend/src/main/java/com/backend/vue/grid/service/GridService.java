package com.backend.vue.grid.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.vue.grid.dao.GridDao;

@Service
public class GridService {
 
	@Autowired
	private GridDao gridDao;
	
	public List<Map<String, Object>> selGridTest() {
		return gridDao.selGridTest();
	}

	public List<Map<String, Object>> selEcoGridList(Map<String, String> selUser) {
		return gridDao.selEcoGridList(selUser);
	}
	
	public List<Map<String, Object>> selEcoGridDetail(String rowId) {
		// Null 체크
	    if (rowId == null) {
	        throw new IllegalArgumentException("Parameter 'param' cannot be null");
	    }
	    
	    try {
	        return gridDao.selEcoGridDetail(rowId);
	    } catch (Exception ex) {
	        // 예외 처리
	        // 로깅 등을 통해 적절한 처리를 수행
	        throw new RuntimeException("Error in selEcoGridDetail", ex);
	    }
		//return gridDao.selEcoGridDetail(param);
	}
	
	public int saveEcoGrid(List<Map<String, Object>> userDetail) {
		return gridDao.saveEcoGrid(userDetail);
	}
	
	public List<Map<String, Object>> delEcoGridDetail(List<String> deployNoList) {
        return gridDao.delEcoGridDetail(deployNoList);
	}
}