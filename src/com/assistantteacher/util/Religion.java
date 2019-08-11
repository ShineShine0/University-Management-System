package com.assistantteacher.util;


public enum Religion {
	buddha(1,"buddha"),
	islam(2,"islam"),
	hindu(3,"hindu"),
	christian(4,"christian"),
	others(5,"otheres");
	
	private int id;
	private String name;
	
	private Religion(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
