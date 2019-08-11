package com.assistantteacher.util;


public enum Citizens {
	
	
	Myanmar(1,"Myanmar"),
	Foreign(2,"Foreign");
	
	private int id;
	private String name;
	
	private Citizens(int id, String name) {
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
