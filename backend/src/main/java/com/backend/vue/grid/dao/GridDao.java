package com.backend.vue.grid.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GridDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selGridTest() {
		List<Map<String, Object>> gridList = new ArrayList<Map<String, Object>>();
		
		gridList = sqlSessionTemplate.selectList("GridMapper.selGridTest");
		
		return gridList;
	}

	public List<Map<String, Object>> selEcoGridList(Map<String, String> selUser) {
		List<Map<String, Object>> gridList = new ArrayList<Map<String, Object>>();
		
		gridList = sqlSessionTemplate.selectList("GridMapper.selEcoGridList", selUser);
		System.out.println(gridList);
		return gridList;
	}
	
	public List<Map<String, Object>> selEcoGridDetail(String rowId) {
		List<Map<String, Object>> gridList = new ArrayList<Map<String, Object>>();
		
		gridList = sqlSessionTemplate.selectList("GridMapper.selEcoGridDetail", rowId);
		System.out.println(gridList);
		return gridList;
	}
	
	public int saveEcoGrid(List<Map<String, Object>> userDetail) {        
        int saveGrid = 0;

        if (!userDetail.isEmpty()) {
        	String deployNo = String.valueOf(userDetail.get(0).get("DEPLOY_NO"));
        	int seq = sqlSessionTemplate.selectOne("GridMapper.getSequenceNumber");
        	
        	HashMap<String, Object> gridMap = new HashMap<String, Object>();
            userDetail.get(0).forEach((key, value) -> { 
                switch (key) {
                    case "DEPLOY_NO", "DEPLOY_NM", "HP_NO", "EMAIL", "ENTR_DT", "RETR_DT", 
                         "WRK_TYP_CD", "DEL_YN", "ID_CHG_PRSN", "IP_CHG_PRSN" -> gridMap.put(key, value);
                }
            });

            List<Map<String, Object>> gridList = sqlSessionTemplate.selectList("GridMapper.selGridList", deployNo);

            if (!gridList.isEmpty()) {
                saveGrid = sqlSessionTemplate.update("GridMapper.saveEcoGrid", gridMap);
            } else {
            	gridMap.put("DEPLOY_NO", "E" + String.valueOf(seq));
                saveGrid = sqlSessionTemplate.insert("GridMapper.insEcoGrid", gridMap);
            }
        }

        return saveGrid;
    }
	
	public List<Map<String, Object>> delEcoGridDetail(List<String> deployNoList) {
	    List<Map<String, Object>> gridList = new ArrayList<>();

	    for (String deployNo : deployNoList) {
	        int delGrid = sqlSessionTemplate.delete("GridMapper.delEcoGridDetail", deployNo);

	        Map<String, Object> result = new HashMap<>();
	        result.put("delGrid", delGrid);
	        gridList.add(result);
	    }
//	    int delGrid = sqlSessionTemplate.delete("GridMapper.delEcoGridDetail", rowId);
//
//	    Map<String, Object> result = new HashMap<>();
//	    result.put("delGrid", delGrid);
//	    gridList.add(result);

	    return gridList;
	}
	
}