package com.assistantteacher.entity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Attendance")
public class Attendance implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="classLevelId")
	private ClassLevel classLevel=new ClassLevel();
	@ManyToOne
	@JoinColumn(name="SectionId")
	private Section section=new Section();
	@JoinColumn(name="SubjectId")
	@ManyToOne
	private Subject subject=new Subject();
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Student student=new Student();
	@Column(name="Status")
	private Boolean status;
	@Column(name="AttCount")
	private double attCount;
	@Column(name="SubjectTime")
	private int subjectTime;
	@Temporal(TemporalType.DATE)
	 private Date date;
	@Temporal(TemporalType.DATE)
	 private Date sysDate;
	@ManyToOne
	@JoinColumn(name="userId")
	private UserInfo user=new UserInfo();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public double getAttCount() {
		return attCount;
	}
	public void setAttCount(double attCount) {
		this.attCount = attCount;
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
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
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
	public Date getSysDate() {
		return sysDate;
	}
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
	
	
	
}
