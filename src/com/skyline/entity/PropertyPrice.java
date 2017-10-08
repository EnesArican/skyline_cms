package com.skyline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="property_price")
public class PropertyPrice {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="Field is required")
	@Column(name="price")
	private String price;

	@NotNull(message="Field is required")
	@Column(name="comission")
	private String comission;
	
	
	public PropertyPrice(){}
	public PropertyPrice(String price, String comission) {
		this.price = price;
		this.comission = comission;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getComission() {
		return comission;
	}
	public void setComission(String comission) {
		this.comission = comission;
	}
	
	

}