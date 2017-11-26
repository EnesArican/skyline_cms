package com.skyline.entity.property;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="property_price")
public class PropertyPrice {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="Field is required")
	@Column(name="price")
	private String price;

	@NotEmpty(message="Field is required")
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
