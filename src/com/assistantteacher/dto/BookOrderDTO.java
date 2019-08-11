package com.assistantteacher.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookOrderDTO  {
	private Long id;
	private Double totalPrice;
	private String status;
	private String invoiceNo;
	private String studentName;
	private Long studentId;
	private Date orderDate;
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public List<BookOrderItemDTO> getOrder() {
		return order;
	}
	public void setOrder(List<BookOrderItemDTO> order) {
		this.order = order;
	}

	public List<BookOrderItemDTO> order=new ArrayList<BookOrderItemDTO>();
	public List<OrderItemDTO> orderItemList=new ArrayList<OrderItemDTO>();
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderItemDTO> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDTO> orderItemList) {
		this.orderItemList = orderItemList;
	}

	

}
