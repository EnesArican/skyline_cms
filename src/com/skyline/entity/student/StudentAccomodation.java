package com.skyline.entity.student;

import java.math.BigDecimal;
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
import com.skyline.entity.property.Property;

@Entity
@Table(name="student_accomodation")
public class StudentAccomodation{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne()
	@JoinColumn(name="property_id")
	private Property property;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
	@JoinColumn(name="price")
	private BigDecimal price;
	
	@JoinColumn(name="commission")
	private BigDecimal commission;
	

	public StudentAccomodation(){}	
	public StudentAccomodation(int id, Student student, Property property, Date startDate, Date endDate,
			BigDecimal price, BigDecimal commission) {
		this.id = id;
		this.student = student;
		this.property = property;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.commission = commission;
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
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
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
	public String toString() {
		return "StudentAccomodation [id=" + id + ", student=" + student + ", property=" + property + ", startDate="
				+ startDate + ", endDate=" + endDate + ", price=" + price + ", commission=" + commission + "]";
	}
	
	
	
	
	
}
