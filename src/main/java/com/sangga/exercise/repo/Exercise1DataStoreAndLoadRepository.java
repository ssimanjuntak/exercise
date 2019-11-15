package com.sangga.exercise.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangga.exercise.entity.Exercise1DataStoreAndLoadEntity;

public interface Exercise1DataStoreAndLoadRepository extends JpaRepository<Exercise1DataStoreAndLoadEntity, Long> {
	
}
