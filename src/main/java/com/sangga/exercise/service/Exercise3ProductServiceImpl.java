package com.sangga.exercise.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangga.exercise.entity.Exercise3ProductEntity;
import com.sangga.exercise.repo.Exercise3ProductRepository;

@Service
@Transactional
public class Exercise3ProductServiceImpl implements Exercise3ProductService {

	@Autowired
    private Exercise3ProductRepository productRepository;

    @Override
    public Exercise3ProductEntity getProduct(long id) {
        return productRepository.findOne(id);
    }
}