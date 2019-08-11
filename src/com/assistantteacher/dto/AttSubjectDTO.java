package com.assistantteacher.dto;

import java.util.ArrayList;
import java.util.List;

public class AttSubjectDTO {

	private Long id;
	private Long studentId;
	private String name;
	List<Double> attCountList=new ArrayList<Double>();
	private double totalCount;
	private String rollNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Double> getAttCountList() {
		return attCountList;
	}
	public void setAttCountList(List<Double> attCountList) {
		this.attCountList = attCountList;
	}
	public double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
}
