package com.assistantteacher.entity;

import java.io.Serializable;
import java.sql.Date;

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

import com.assistantteacher.dto.StudentDTO;

@Entity
@Table(name="Student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="RollNo")
	private String rollNo;
	@Column(name="NRC")
	private String nrc;
	@Column(name="DOB")
	private Date dob;
	@Column(name="RunningYear")
	private String runningYear;
	@Column(name="Gender")
	private String gender;
	@Column(name="Address")
	private String address;
	@Column(name="Phone")
	private String phone;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	@Column(name="UserImage")
	private String imagepath;
	
	@Column(name="Nationality")
	private String nationality;
	@Column(name="Religion")
	private String religion;
	@Column(name="Citizen")
	private String citizen;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "userId")
	private UserInfo user= new UserInfo();
	@ManyToOne
	@JoinColumn(name= "classLevelId")
	private ClassLevel classLevel = new ClassLevel();
	@ManyToOne
	@JoinColumn(name= "sectionId")
	private Section section = new Section();
	@ManyToOne
	@JoinColumn(name= "MajorId")
	private Major major = new Major();
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
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getRunningYear() {
		return runningYear;
	}
	public void setRunningYear(String runningYear) {
		this.runningYear = runningYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCitizen() {
		return citizen;
	}
	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public ClassLevel getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(ClassLevel classLevel) {
		this.classLevel = classLevel;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
