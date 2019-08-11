package com.assistantteacher.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubjectDTO implements Serializable {
	private Long id;
	private String name;
	private List<Long> majorIdList= new ArrayList<>();
	private String majorName;
	private Long adminId;
	private String adminName;
	private Long classLevelId;
	private String classLevelName;
	private String teacherName;
	
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
	
	public List<Long> getMajorIdList() {
		return majorIdList;
	}
	public void setMajorIdList(List<Long> majorIdList) {
		this.majorIdList = majorIdList;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	

}
