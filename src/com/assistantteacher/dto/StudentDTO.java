package com.assistantteacher.dto;

import java.io.Serializable;
import java.sql.Date;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class StudentDTO implements Serializable{
	@NotEmpty
	private MultipartFile imgfile;
	private Long id;
	private String name;
	private String rollNo;
	private String nrc;
	private Date dob;
	private String runningYear;
	private String gender;
	private String address;
	private String phone;
	private String email;
	private String password;
	private String imagepath;
	private String nationality;
	private String religion;
	private String citizen;
	private Long userId;
	private String userName;
	
	private Long classLevelId;
	private String classLevelName;
	private Long sectionId;
	private String sectionName;
	private Long majorId;
	private String majorName;
	
	private Long adminRoleId;
	private String adminRoleName;
	public MultipartFile getImgfile() {
		return imgfile;
	}
	public void setImgfile(MultipartFile imgfile) {
		this.imgfile = imgfile;
	}
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getClassLevelId() {
		return classLevelId;
	}
	public void setClassLevelId(Long classLevelId) {
		this.classLevelId = classLevelId;
	}
	public String getClassLevelName() {
		return classLevelName;
	}
	public void setClassLevelName(String classLevelName) {
		this.classLevelName = classLevelName;
	}
	public Long getSectionId() {
		return sectionId;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Long getMajorId() {
		return majorId;
	}
	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Long getAdminRoleId() {
		return adminRoleId;
	}
	public void setAdminRoleId(Long adminRoleId) {
		this.adminRoleId = adminRoleId;
	}
	public String getAdminRoleName() {
		return adminRoleName;
	}
	public void setAdminRoleName(String adminRoleName) {
		this.adminRoleName = adminRoleName;
	}

}
