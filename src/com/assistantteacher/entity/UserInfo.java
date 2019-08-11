package com.assistantteacher.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sun.security.util.Password;

@Entity
@Table(name="UserInfo")
public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	@Column(name="UserImage")
	private String imagePath;
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Column(name="UserName")
	private String userName;
	@Column(name= "Password")
	private String password;
	@Column(name= "OldPassword")
	private String oldPassword;
	@Column(name= "Position")
	private String position;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roleId")
	private AdminRole role = new AdminRole();
	@ManyToMany(mappedBy = "teacher")
	private List<Activity> activitiesList= new ArrayList<Activity>();
	
	@OneToMany(mappedBy = "user")
	private List<Document> documentList= new ArrayList<Document>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public AdminRole getRole() {
		return role;
	}
	public void setRole(AdminRole role) {
		this.role = role;
	}
	public List<Activity> getActivitiesList() {
		return activitiesList;
	}
	public void setActivitiesList(List<Activity> activitiesList) {
		this.activitiesList = activitiesList;
	}
	public List<Document> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}
	
	

}
