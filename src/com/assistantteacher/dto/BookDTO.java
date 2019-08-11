package com.assistantteacher.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class BookDTO {
	private Long id;
	private String name;
	private double price;
	private String author;
	private String isbn;
	private String edition;
	private String imagepath;
	private Long qty;
	@NotEmpty
	private MultipartFile imgfile;
	
	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	private Long classLevelId;
	private String classLevelName;

	public Long getClassLevelId() {
		return classLevelId;
	}

	public void setClassLevelId(Long classLevelId) {
		this.classLevelId = classLevelId;
	}

	public String getClassLevelName() {
		return classLevelName;
	}

	public void setClassLevelName(String classLevelName) {
		this.classLevelName = classLevelName;
	}

	public MultipartFile getImgfile() {
		return imgfile;
	}

	public void setImgfile(MultipartFile imgfile) {
		this.imgfile = imgfile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}



	

}


