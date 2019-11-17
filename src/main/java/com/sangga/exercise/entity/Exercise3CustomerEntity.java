package com.sangga.exercise.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exercise3_mst_customer")
public class Exercise3CustomerEntity {
	
	@Id
    private String id;
	private String name;
	private Boolean isEmployee;
	private Boolean isAffiliate;
	private Date joinDate;
    
    public Exercise3CustomerEntity() {}
    
    public Exercise3CustomerEntity(String id) {
        this.id = id;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public Boolean getIsAffiliate() {
		return isAffiliate;
	}

	public void setIsAffiliate(Boolean isAffiliate) {
		this.isAffiliate = isAffiliate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}