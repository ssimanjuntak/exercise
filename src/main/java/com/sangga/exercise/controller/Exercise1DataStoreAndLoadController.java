package com.sangga.exercise.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangga.exercise.entity.Exercise1DataStoreAndLoadEntity;
import com.sangga.exercise.service.Exercise1DataStoreAndLoadDaoService;
import com.sangga.exercise.util.JsonUtil;

@RestController
@RequestMapping("/storeandload")
public class Exercise1DataStoreAndLoadController {
	
	@Autowired
	Exercise1DataStoreAndLoadDaoService service;
	
	@PostMapping
    public @ResponseBody String store(@RequestBody List<Map<String, String>> list) throws Exception {

		Exercise1DataStoreAndLoadEntity entity = new Exercise1DataStoreAndLoadEntity();
		StringBuffer sbf = new StringBuffer("text=");
		list.forEach((item) -> {
			item.forEach((k,v) -> {
				sbf.append(k);
				sbf.append("=");
				sbf.append(v);
			});
			sbf.append("\n");
			}
			);
		
		entity.setText(sbf.toString());
		
		entity = service.save(entity);
		
        return sbf + " Success Save with id " + String.valueOf(entity.getId());
    }
	
	@GetMapping
    public @ResponseBody String load(@RequestParam(name="id", defaultValue="") long id) throws Exception {

		Exercise1DataStoreAndLoadEntity entity = service.get(id);
		
		entity.setText("ewe");
		
        return JsonUtil.generateJson(entity);
    }

}
