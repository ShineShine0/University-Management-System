package com.assistantteacher.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.assistantteacher.dto.ClassLevelDTO;

@Entity
@Table(name="Subject")
public class Subject implements Serializable{

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
	@ManyToOne
	@JoinColumn(name="ClassLevelId")
	private ClassLevel classLevel =new ClassLevel();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subject_major" , joinColumns= {@JoinColumn(name= "subjectId" , nullable = false)},
	inverseJoinColumns= {@JoinColumn(name= "majorId",nullable =false)})
	private List<Major> majorList = new ArrayList<Major>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subject_teacher" , joinColumns= {@JoinColumn(name= "subjectId" , nullable = false)},
	inverseJoinColumns= {@JoinColumn(name= "teacherId",nullable =false)})
	private List<Admin> teacher = new ArrayList<Admin>();

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

	public ClassLevel getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(ClassLevel classLevel) {
		this.classLevel = classLevel;
	}

	public List<Major> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}

	public List<Admin> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Admin> teacher) {
		this.teacher = teacher;
	}


}
