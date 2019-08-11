package com.assistantteacher.dto;

public class SectionDTO {
	private Long id;
	private String name;
	private Long classLevelId;
	private String classLevelName;
	private Long adminId;
	private String adminName;
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
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	

}
