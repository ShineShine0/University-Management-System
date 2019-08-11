package com.assistantteacher.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import sun.security.util.Password;



public class AdminDTO implements Serializable{
	@NotEmpty
	private MultipartFile imgfile;
	private Long id;
	
	
	private String name;
	
	private String nrc;
	
	private String address;
	
	private String  dob;
	
	private String mobileNumber;
	
	private String email;

	private String password;
	
	
	private String imagePath;
	
	
	private String position;

	private String gender;

	private String nationality;
	private Long departmentId;
	private Long userId;
	
	private Long roleId;
	private Long adminRoleId;
	private String adminRoleName;
	 
	
	private String departmentName;
	 public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	 public String getAdminRoleName() {
			return adminRoleName;
		}
		public void setAdminRoleName(String adminRoleName) {
			this.adminRoleName = adminRoleName;
		}
		public Long getAdminRoleId() {
			return adminRoleId;
		}
		public void setAdminRoleId(Long adminRoleId) {
			this.adminRoleId = adminRoleId;
		}
		public MultipartFile getImgfile() {
			return imgfile;
		}
		public void setImgfile(MultipartFile imgfile) {
			this.imgfile = imgfile;
		}

}
