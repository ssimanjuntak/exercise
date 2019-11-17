package com.sangga.exercise.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
public class Exercise3OrderProductPK implements Serializable {

    private static final long serialVersionUID = 476151177562655457L;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Exercise3OrderEntity order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Exercise3ProductEntity product;

    public Exercise3OrderEntity getOrder() {
        return order;
    }

    public void setOrder(Exercise3OrderEntity order) {
        this.order = order;
    }

    public Exercise3ProductEntity getProduct() {
        return product;
    }

    public void setProduct(Exercise3ProductEntity product) {
        this.product = product;
    }
}