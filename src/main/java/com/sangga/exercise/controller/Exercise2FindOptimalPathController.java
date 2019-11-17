package com.sangga.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangga.exercise.entity.Exercise2ResultEntity;
import com.sangga.exercise.service.Exercise2FindOptimalPathDaoService;
import com.sangga.exercise.util.JsonUtil;

@RestController
@RequestMapping("/optimalpath")
public class Exercise2FindOptimalPathController {
	
	@Autowired
	Exercise2FindOptimalPathDaoService service;
	
	@PostMapping
    public @ResponseBody String findOptimalPath(@RequestBody int[][] adjacencyMatrix) throws Exception {
		
		List<Exercise2ResultEntity> exercise2Results = service.findOptimalPath(adjacencyMatrix, 0);
		
        return JsonUtil.generateJson(exercise2Results);
    }

}
