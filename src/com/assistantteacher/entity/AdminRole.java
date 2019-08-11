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
import javax.persistence.Table;

@Entity
@Table(name="AdminRole")
public class AdminRole  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1282636485572036954L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	@Column(name="Name")
	private String name;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="AdminRole_has_AdminPriviliges",
	joinColumns={@JoinColumn(name="AdminRoleId",nullable=false)},
	inverseJoinColumns={@JoinColumn(name="AdminPriviligesId",nullable=false)})	
	private List<AdminPriviliges> priviligesList=new ArrayList<AdminPriviliges>();
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
	public List<AdminPriviliges> getPriviligesList() {
		return priviligesList;
	}
	public void setPriviligesList(List<AdminPriviliges> priviligesList) {
		this.priviligesList = priviligesList;
	}
	
	
}
