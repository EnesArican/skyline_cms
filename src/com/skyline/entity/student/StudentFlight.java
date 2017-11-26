package com.skyline.entity.student;

import java.sql.Time;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_flight")
public class StudentFlight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="airport")
	private String airport;

	@Column(name="flight_number")
	private String flightNumber;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="time")
	private Time time;
	
	@ManyToOne()
	@JoinColumn(name="student_id")
	private Student student;

	public StudentFlight(){}
	public StudentFlight(String airport, String flightNumber, Date date, Time time, Student student) {
		this.airport = airport;
		this.flightNumber = flightNumber;
		this.date = date;
		this.time = time;
		this.student = student;
	}
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	
}
