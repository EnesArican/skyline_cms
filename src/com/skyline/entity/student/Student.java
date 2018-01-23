package com.skyline.entity.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="Field is required")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message="Field is required")
	@Column(name="surname")
	private String surname;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull(message="Field is required")
	@Column(name="dob")
	private Date dob;
	
	@NotEmpty(message="Field is required")
	@Column(name="gender")
	private String gender;
	
	@NotNull(message="Field is required")
	@Column(name="mobile")
	private String mobile;
	
	@NotEmpty(message="Field is required")
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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="school_id")
	private StudentSchool studentSchool;
	
	@NotEmpty(message="Field is required")
	@Column(name="kin_name")
	private String kinName;
	
	@NotEmpty(message="Field is required")
	@Column(name="kin_surname")
	private String kinSurname;
	
	@NotEmpty(message="Field is required")
	@Column(name="kin_relation")
	private String kinRelation;
	
	@NotNull(message="Field is required")
	@Column(name="kin_mobile")
	private String kinMobile;
	
	@Column(name="kin_email")
	private String kinEmail;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(fetch = FetchType.LAZY, mappedBy="student" ,cascade=CascadeType.ALL)
	//@JoinColumn(name="student_flight_id")
	private List<StudentFlight> studentFlight;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name="student_id", referencedColumnName="id")
	private List<StudentAccomodation> studentAccomodations;
	
	public Student(){}	
	public Student(int id, String name, String surname, Date dob, String gender, String mobile, String email,
			String address, String postCode, StudentSchool studentSchool, String kinName, String kinSurname,
			String kinRelation, String kinMobile, String kinEmail, List<StudentFlight> studentFlight,
			List<StudentAccomodation> studentAccomodations) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.postCode = postCode;
		this.studentSchool = studentSchool;
		this.kinName = kinName;
		this.kinSurname = kinSurname;
		this.kinRelation = kinRelation;
		this.kinMobile = kinMobile;
		this.kinEmail = kinEmail;
		this.studentFlight = studentFlight;
		this.studentAccomodations = studentAccomodations;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public StudentSchool getStudentSchool() {
		return studentSchool;
	}
	public void setStudentSchool(StudentSchool studentSchool) {
		this.studentSchool = studentSchool;
	}
	public String getKinName() {
		return kinName;
	}
	public void setKinName(String kinName) {
		this.kinName = kinName;
	}
	public String getKinSurname() {
		return kinSurname;
	}
	public void setKinSurname(String kinSurname) {
		this.kinSurname = kinSurname;
	}
	public String getKinRelation() {
		return kinRelation;
	}
	public void setKinRelation(String kinRelation) {
		this.kinRelation = kinRelation;
	}
	public String getKinMobile() {
		return kinMobile;
	}
	public void setKinMobile(String kinMobile) {
		this.kinMobile = kinMobile;
	}
	public String getKinEmail() {
		return kinEmail;
	}
	public void setKinEmail(String kinEmail) {
		this.kinEmail = kinEmail;
	}
	public List<StudentFlight> getStudentFlight() {
		return studentFlight;
	}
	public void setStudentFlight(List<StudentFlight> studentFlight) {
		this.studentFlight = studentFlight;
	}
	public List<StudentAccomodation> getStudentAccomodations() {
		return studentAccomodations;
	}
	public void setStudentAccomodations(List<StudentAccomodation> studentAccomodations) {
		this.studentAccomodations = studentAccomodations;
	}

	
	// add convenience methods for bi-directional relationship
	
	public void addFlight(StudentFlight tempStudentFlight){
		
		if (studentFlight == null){
			studentFlight = new ArrayList<>();
		}
		
		studentFlight.add(tempStudentFlight);
		
		//tempStudentFlight.setStudent(this);
	}
	
	
	
}




