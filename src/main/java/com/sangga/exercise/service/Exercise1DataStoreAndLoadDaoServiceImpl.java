package com.sangga.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangga.exercise.entity.Exercise1DataStoreAndLoadEntity;
import com.sangga.exercise.repo.Exercise1DataStoreAndLoadRepository;


@Service
public class Exercise1DataStoreAndLoadDaoServiceImpl implements Exercise1DataStoreAndLoadDaoService {
	
	
	@Autowired
	Exercise1DataStoreAndLoadRepository repo;
	
	@Override
	public Exercise1DataStoreAndLoadEntity get(long id) {
		return repo.findOne(id);
	}

	@Override
	public Exercise1DataStoreAndLoadEntity save(Exercise1DataStoreAndLoadEntity exercise1DataStoreAndLoadEntity) {
		return repo.save(exercise1DataStoreAndLoadEntity);
	}

}
