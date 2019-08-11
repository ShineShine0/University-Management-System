package com.assistantteacher.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sun.security.util.Password;
@Entity
@Table(name="Admin")
public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3008009785019520550L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="NRC")
	private String nrc;
	@Column(name="Address")
	private String address;
	@Column(name="DOB")
	private String dob;
	@Column(name="MobileNumber")
	private String mobileNumber;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	
	
	@Column(name="Position")
	private String position;
	@Column(name="Gender")
	private String gender;
	@Column(name="Nationality")
	private String nationality;
	
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department=new Department();
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="userId")
	private UserInfo user= new UserInfo();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String  dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	
	
	

}
