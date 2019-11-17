package com.sangga.exercise.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sangga.exercise.dto.OrderDto;
import com.sangga.exercise.dto.OrderProductDto;
import com.sangga.exercise.entity.Exercise3OrderEntity;
import com.sangga.exercise.exception.DataNotFound;
import com.sangga.exercise.service.Exercise3OrderService;
import com.sangga.exercise.service.Exercise3ProductService;
import com.sangga.exercise.util.JsonUtil;

@RestController
@RequestMapping("/discountpurchase")
public class Exercise3DiscountPurchaseController {
	
	@Autowired
	Exercise3OrderService orderService;
	
	@Autowired
	Exercise3ProductService productService;
	
	@PostMapping
    public @ResponseBody String findOptimalPath(@RequestBody OrderDto orderDto) throws Exception {
		
		validateProducts(orderDto.getOrderProducts());

		Exercise3OrderEntity order = orderService.calculateOrder(orderDto);
		
        return JsonUtil.generateJson(order);
    }

    private void validateProducts(List<OrderProductDto> orderProducts) throws JsonProcessingException {
        List<OrderProductDto> list = orderProducts
          .stream()
          .filter(op -> Objects.isNull(productService.getProduct(op.getProductId())))
          .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
        	throw new DataNotFound("Exercise3ProductEntity id : " + JsonUtil.generateJson(list) + " not found");
        }
    }

}