package com.sangga.exercise.dto;

public class OrderProductDto {

    private Integer quantity;
    private long productId;

    public OrderProductDto() {}

    public OrderProductDto(Integer quantity, long productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

}