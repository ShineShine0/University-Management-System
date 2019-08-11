package com.assistantteacher.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Section")
public class Section implements Serializable{

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
	@JoinColumn(name ="classLevelId")
	private ClassLevel classLevel= new ClassLevel();
	@ManyToOne
	@JoinColumn(name ="adminId" ,nullable =true)
	private Admin admin= new Admin();
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	

}
