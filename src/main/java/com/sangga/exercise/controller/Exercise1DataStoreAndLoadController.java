package com.sangga.exercise.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import com.sangga.exercise.entity.Exercise1DataStoreAndLoadEntity;
import com.sangga.exercise.exception.DataNotFound;
import com.sangga.exercise.service.Exercise1DataStoreAndLoadDaoService;
import com.sangga.exercise.util.JsonUtil;

@RestController
@RequestMapping("/storeandload")
public class Exercise1DataStoreAndLoadController {
	
	@Autowired
	Exercise1DataStoreAndLoadDaoService service;
	
	@PostMapping
    public @ResponseBody String store(@RequestBody List<HashMap<String, String>> list) throws Exception {

        return " Success Save with id " + String.valueOf(service.save(list).getId());
    }
	
	@GetMapping
    public @ResponseBody String load(@RequestParam(name="id", defaultValue="") long id) throws Exception {

        return JsonUtil.generateJson(service.get(id));
    }

}
