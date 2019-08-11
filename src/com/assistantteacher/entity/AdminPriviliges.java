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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="AdminPriviliges")
public class AdminPriviliges implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2696462825577867156L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="RoleCode")
	private String roleCode;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="priviligesList")
	private List<AdminRole> roleList=new ArrayList<AdminRole>();
	
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
	public List<AdminRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<AdminRole> roleList) {
		this.roleList = roleList;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
	
	
	
	
}
