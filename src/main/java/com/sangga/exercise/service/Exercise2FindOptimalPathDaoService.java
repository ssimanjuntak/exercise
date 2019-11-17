package com.sangga.exercise.service;

import java.util.List;

import com.sangga.exercise.entity.Exercise2ResultEntity;

public interface Exercise2FindOptimalPathDaoService {
	
	List<Exercise2ResultEntity> findOptimalPath(int[][] adjacencyMatrix, int startVertex) throws Exception;
	
}
