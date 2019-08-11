package com.assistantteacher.entity;

import java.io.Serializable;
import java.sql.Date;
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

@Entity
@Table(name="Document")
public class Document implements Serializable{

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
	@Column(name="Date")
	private Date date;
	@Column(name="DataPath")
	private String dataPath;
	@Column(name="ImagePath")
	private String imagePath;
	@Column(name="Title")
	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@ManyToOne
	@JoinColumn(name= "userId")
	private UserInfo user = new UserInfo();
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_document" , joinColumns= {@JoinColumn(name= "documentId" , nullable = false)},
	inverseJoinColumns= {@JoinColumn(name= "userId",nullable =false)})
	private List<UserInfo> documentList = new ArrayList<UserInfo>();*/
	@ManyToOne
	@JoinColumn(name= "classLevelId")
	private ClassLevel classLevel = new ClassLevel();
	@ManyToOne
	@JoinColumn(name= "subjectId")
	private Subject subject = new Subject();
	@ManyToOne
	@JoinColumn(name= "sectionId")
	private Section section = new Section();
	

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public ClassLevel getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(ClassLevel classLevel) {
		this.classLevel = classLevel;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	/*public List<UserInfo> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<UserInfo> documentList) {
		this.documentList = documentList;
	}*/
	

}
