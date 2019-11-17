package com.sangga.exercise.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private String customerId;

    private List<OrderProductDto> orderProducts = new ArrayList<>();
    
    public OrderDto() {}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<OrderProductDto> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProductDto> orderProducts) {
		this.orderProducts = orderProducts;
	}
    
}
