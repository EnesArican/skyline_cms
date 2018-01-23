package com.skyline.entity.student;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student_flight")
public class StudentFlight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="student_id")
	private Student student;

	@Column(name="pickup_airport")
	private String pickupAirport;
	
	@Column(name="pickup_flight_number")
	private String pickupFlightNumber;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="pickup_date")
	private Date pickupDate;
	
	@Column(name="pickup_time")
	private String pickupTime;
	
	@Column(name="dropoff_airport")
	private String dropoffAirport;

	@Column(name="dropoff_flight_number")
	private String dropoffFlightNumber;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="dropoff_date")
	private Date dropoffDate;
	
	@Column(name="dropoff_time")
	private String dropoffTime;

	public StudentFlight(){}
	public StudentFlight(int id, Student student, String pickupAirport, String pickupFlightNumber, Date pickupDate,
			String pickupTime, String dropoffAirport, String dropoffFlightNumber, Date dropoffDate, String dropoffTime) {
		this.id = id;
		this.student = student;
		this.pickupAirport = pickupAirport;
		this.pickupFlightNumber = pickupFlightNumber;
		this.pickupDate = pickupDate;
		this.pickupTime = pickupTime;
		this.dropoffAirport = dropoffAirport;
		this.dropoffFlightNumber = dropoffFlightNumber;
		this.dropoffDate = dropoffDate;
		this.dropoffTime = dropoffTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getPickupAirport() {
		return pickupAirport;
	}
	public void setPickupAirport(String pickupAirport) {
		this.pickupAirport = pickupAirport;
	}
	public String getPickupFlightNumber() {
		return pickupFlightNumber;
	}
	public void setPickupFlightNumber(String pickupFlightNumber) {
		this.pickupFlightNumber = pickupFlightNumber;
	}
	public Date getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	public String getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}
	public String getDropoffAirport() {
		return dropoffAirport;
	}
	public void setDropoffAirport(String dropoffAirport) {
		this.dropoffAirport = dropoffAirport;
	}
	public String getDropoffFlightNumber() {
		return dropoffFlightNumber;
	}
	public void setDropoffFlightNumber(String dropoffFlightNumber) {
		this.dropoffFlightNumber = dropoffFlightNumber;
	}
	public Date getDropoffDate() {
		return dropoffDate;
	}
	public void setDropoffDate(Date dropoffDate) {
		this.dropoffDate = dropoffDate;
	}
	public String getDropoffTime() {
		return dropoffTime;
	}
	public void setDropoffTime(String dropoffTime) {
		this.dropoffTime = dropoffTime;
	}
	
	
	
	
	
	
}
