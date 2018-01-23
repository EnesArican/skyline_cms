package com.skyline.entity.property;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="property")
public class Property implements Comparable<Property>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="sky_code")
	private Integer skyCode;
	
	@NotEmpty(message="Field is required")
	@Size(min=5, message="minimum 5 characters" )
	@Column(name="address")
	private String address;
	
	@NotEmpty(message="Field is required")
	@Size(min=4, message="minimum 4 characters" )
	@Column(name="post_code")
	private String postCode;
	
	@NotNull(message="Field is required")
	@Column(name="tube_zone")
	private Integer  tubeZone;
	
	@ManyToOne()
	@JoinColumn(name="type_id")
	private PropertyType propertyType ;
	
	@NotNull(message="Field is required")
	@Column(name="gender")
	private String gender;
	
	@NotNull(message="Field is required")
	@Pattern(regexp="(^\\d+$|(?i)^N\\/A$)", message="Invalid Input, Enter 'N/A' of a number")
	@Column(name="capacity")
	private String capacity;
	
	@NotNull(message="Field is required")
	@JoinColumn(name="price")
	private BigDecimal price;
	
	@NotNull(message="Field is required")
	@JoinColumn(name="commission")
	private BigDecimal commission;
	
	
	public Property(){
		
	}
	public Property(int id, Integer skyCode, String address, String postCode, Integer tubeZone,
			PropertyType propertyType, String gender, String capacity, BigDecimal price, BigDecimal commission) {
		this.id = id;
		this.skyCode = skyCode;
		this.address = address;
		this.postCode = postCode;
		this.tubeZone = tubeZone;
		this.propertyType = propertyType;
		this.gender = gender;
		this.capacity = capacity;
		this.price = price;
		this.commission = commission;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getSkyCode() {
		return skyCode;
	}
	public void setSkyCode(Integer skyCode) {
		this.skyCode = skyCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Integer getTubeZone() {
		return tubeZone;
	}
	public void setTubeZone(Integer tubeZone) {
		this.tubeZone = tubeZone;
	}
	public PropertyType getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getCommission() {
		return commission;
	}
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
	@Override
	public int compareTo(Property compareProperty) {
		int compareSkyCode = compareProperty.getSkyCode();
		return this.skyCode - compareSkyCode;
	}
	
		
	
	
	
	
	
	
}
