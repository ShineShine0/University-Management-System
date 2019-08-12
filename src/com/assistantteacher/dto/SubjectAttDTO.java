package com.assistantteacher.dto;

public class SubjectAttDTO {
	
	private String subjectName;
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public double getAttCount() {
		return attCount;
	}
	public void setAttCount(double attCount) {
		this.attCount = attCount;
	}
	private double attCount;

}
