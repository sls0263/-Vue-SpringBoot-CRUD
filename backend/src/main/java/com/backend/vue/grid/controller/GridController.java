package com.backend.vue.grid.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.vue.grid.service.GridService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/grid")
public class GridController {
	@Autowired   
	GridService gridService;

	//테스트 용
	@RequestMapping(value="/test")
	public List<Map<String, Object>> test() {
        return gridService.selGridTest();
	}
	
	@PostMapping(value= "/selEcoGridList")
	public List<Map<String, Object>> selEcoGridList(@RequestBody Map<String, String> selUser) {
		List<Map<String, Object>> result = gridService.selEcoGridList(selUser);
        return result;
	}
	
	@PostMapping(value= "/selEcoGridDetail")
	public List<Map<String, Object>> selEcoGridDetail(@RequestBody Map<String, String> request) {
		String rowId = request.get("rowId");
//		Map<String, Object> list = gridService.selGridList();
//        model.addAttribute("list", list);
//        return "Grid";
        return gridService.selEcoGridDetail(rowId);
	}
	
	@PostMapping(value= "/saveEcoGrid")
	public int saveEcoGrid(@RequestBody List<Map<String, Object>> userDetail) {
	    int result = gridService.saveEcoGrid(userDetail);
	    return result;
	}
	
	@PostMapping(value= "/delEcoGridDetail")
	public List<Map<String, Object>> delEcoGridDetail(@RequestBody List<String> deployNoList) {
		//String rowId = request.get("deployNoDel");
        return gridService.delEcoGridDetail(deployNoList); 
	}
}
