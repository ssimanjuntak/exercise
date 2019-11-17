package com.sangga.exercise.service;

import com.sangga.exercise.dto.OrderDto;
import com.sangga.exercise.entity.Exercise3OrderEntity;

public interface Exercise3OrderService {

	Exercise3OrderEntity calculateOrder(OrderDto orderDto) throws Exception;
}
