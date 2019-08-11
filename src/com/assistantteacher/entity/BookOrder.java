package com.assistantteacher.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Controller;

@Entity

public class BookOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5035753955807361527L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Double totalPrice;
	private String invoiceNo;
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "bookOrder",cascade=CascadeType.ALL)
	private List<BookOrderItem> item=new ArrayList<BookOrderItem>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	public List<BookOrderItem> getItem() {
		return item;
	}

	public void setItem(List<BookOrderItem> item) {
		this.item = item;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}


	@ManyToOne()
	@JoinColumn(name="userInfoId")
	private UserInfo userInfo=new UserInfo();

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}
