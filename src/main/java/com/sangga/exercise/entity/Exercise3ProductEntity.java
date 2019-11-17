package com.sangga.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exercise3_mst_product")
public class Exercise3ProductEntity {

    @Id
    private Long id;

    private String name;
    
	private String category;
    private Double price;

    public Exercise3ProductEntity(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Exercise3ProductEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
