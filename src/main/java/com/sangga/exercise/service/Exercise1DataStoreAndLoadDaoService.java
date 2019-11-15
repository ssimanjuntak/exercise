package com.sangga.exercise.service;

import com.sangga.exercise.entity.Exercise1DataStoreAndLoadEntity;

public interface Exercise1DataStoreAndLoadDaoService {
	
	Exercise1DataStoreAndLoadEntity get(long id);
	Exercise1DataStoreAndLoadEntity save(Exercise1DataStoreAndLoadEntity exercise1DataStoreAndLoadEntity);
	
}
