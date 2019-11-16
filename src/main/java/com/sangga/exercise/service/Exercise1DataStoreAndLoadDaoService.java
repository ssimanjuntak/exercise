package com.sangga.exercise.service;

import java.util.HashMap;
import java.util.List;

import com.sangga.exercise.entity.Exercise1DataStoreAndLoadEntity;

public interface Exercise1DataStoreAndLoadDaoService {
	
	List<HashMap<String, String>> get(long id) throws Exception;
	Exercise1DataStoreAndLoadEntity save(List<HashMap<String, String>> list);
	
}
