package com.sangga.exercise.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exercise3OrderProductEntity {

    @EmbeddedId
    @JsonIgnore
    private Exercise3OrderProductPK pk;

    @Column(nullable = false) 
    private Integer quantity;

    public Exercise3OrderProductEntity() {
        super();
    }

    public Exercise3OrderProductEntity(Exercise3OrderEntity order, Exercise3ProductEntity product, Integer quantity) {
        pk = new Exercise3OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    @Transient
    public Exercise3ProductEntity getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }
    
    @Transient
    public Double getTotalPriceNotEligibleForDiscount() {
        return getProduct().getCategory().equalsIgnoreCase("groceries") ? getProduct().getPrice() * getQuantity() : 0D;
    }

    public Exercise3OrderProductPK getPk() {
        return pk;
    }

    public void setPk(Exercise3OrderProductPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}