package com.skyline.entity.property;

import java.util.Date;


public class Booking {

	//private String name;
	//private String surname;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer numberOfStudents;
	
	public Booking(){}
	public Booking(Date startDate, Date endDate, Integer numberOfStudents) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfStudents = numberOfStudents;
	}


	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(Integer numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
	
}
