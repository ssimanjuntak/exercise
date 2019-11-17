package com.sangga.exercise.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangga.exercise.entity.Exercise3CustomerEntity;
import com.sangga.exercise.repo.Exercise3CustomerRepository;

@Service
@Transactional
public class Exercise3CustomerServiceImpl implements Exercise3CustomerService {

	@Autowired
    private Exercise3CustomerRepository customerRepository;

    @Override
    public Exercise3CustomerEntity getCustomer(String id) {
        return customerRepository.findOne(id);
    }
}