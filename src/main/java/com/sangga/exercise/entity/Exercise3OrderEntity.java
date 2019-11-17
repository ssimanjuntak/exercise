package com.sangga.exercise.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exercise3_trx_orders")
public class Exercise3OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Exercise3CustomerEntity customer;

    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<Exercise3OrderProductEntity> orderProducts = new ArrayList<>();
    
    private Double totalPriceAfterDiscount;
    
    public Exercise3OrderEntity() {}
    
    public Exercise3OrderEntity(Exercise3CustomerEntity customer) {
        this.customer = customer;
    }

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<Exercise3OrderProductEntity> orderProducts = getOrderProducts();
        for (Exercise3OrderProductEntity op : orderProducts) {
            sum += op.getTotalPrice();
        }

        return sum;
    }
    
    //point 5. discount not applied for groceries
    @Transient
    @JsonIgnore
    public Double getTotalOrderPriceForCalculateDiscount() {
        double sum = 0D;
        List<Exercise3OrderProductEntity> orderProducts = getOrderProducts();
        for (Exercise3OrderProductEntity op : orderProducts) {
            sum += op.getTotalPrice() - op.getTotalPriceNotEligibleForDiscount();
        }

        return sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Exercise3OrderProductEntity> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<Exercise3OrderProductEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

	public Exercise3CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(Exercise3CustomerEntity customer) {
		this.customer = customer;
	}

	public Double getTotalPriceAfterDiscount() {
		return totalPriceAfterDiscount;
	}

	public void setTotalPriceAfterDiscount(Double totalPriceAfterDiscount) {
		this.totalPriceAfterDiscount = totalPriceAfterDiscount;
	}
}
