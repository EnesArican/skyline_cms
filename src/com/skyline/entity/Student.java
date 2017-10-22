package com.skyline.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile")
	private int mobile;
	
	@Column(name="email")
	private String email;
	
	@NotNull(message="Field is required")
	@Size(min=5, message="minimum 5 characters" )
	@Column(name="address")
	private String address;
	
	@NotNull(message="Field is required")
	@Size(min=4, message="minimum 4 characters" )
	@Column(name="post_code")
	private String postCode;

}
