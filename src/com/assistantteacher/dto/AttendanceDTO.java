package com.assistantteacher.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceDTO implements Serializable {
	private Long id;
	private String rollNo;
	private String name;
  private Date date;
  private String attDateString;
  private Long classLevelId;
  private Long sectionId;
  private Long subjectId;
  private int attCount;
  private Long majorId;
  private int subjectTime;
  private String subjectName;
  private Long userId;
  private int month;
  private int fromMonth;
  private int toMonth;
  
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
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
private List<AttendanceStudentDTO> attStudentList=new ArrayList<AttendanceStudentDTO>();
public Long getMajorId() {
	return majorId;
}
public void setMajorId(Long majorId) {
	this.majorId = majorId;
}
public int getSubjectTime() {
	return subjectTime;
}
public void setSubjectTime(int subjectTime) {
	this.subjectTime = subjectTime;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public Long getClassLevelId() {
	return classLevelId;
}
public void setClassLevelId(Long classLevelId) {
	this.classLevelId = classLevelId;
}
public Long getSectionId() {
	return sectionId;
}
public void setSectionId(Long sectionId) {
	this.sectionId = sectionId;
}
public Long getSubjectId() {
	return subjectId;
}
public void setSubjectId(Long subjectId) {
	this.subjectId = subjectId;
}
public String getAttDateString() {
	return attDateString;
}
public void setAttDateString(String attDateString) {
	this.attDateString = attDateString;
}

public int getAttCount() {
	return attCount;
}
public void setAttCount(int attCount) {
	this.attCount = attCount;
}
public List<AttendanceStudentDTO> getAttStudentList() {
	return attStudentList;
}
public void setAttStudentList(List<AttendanceStudentDTO> attStudentList) {
	this.attStudentList = attStudentList;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getFromMonth() {
	return fromMonth;
}
public void setFromMonth(int fromMonth) {
	this.fromMonth = fromMonth;
}
public int getToMonth() {
	return toMonth;
}
public void setToMonth(int toMonth) {
	this.toMonth = toMonth;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}
  
  
  
}
