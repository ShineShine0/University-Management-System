package com.assistantteacher.util;


public enum Nationality {
	
	kachin(1,"kachin"),
	kayar(2,"kayar"),
	kayin(2,"kayin"),
	chin(3,"chin"),
	barma(4,"barma"),
	mon(5,"mon"),
	yakhine(6,"yakhine"),
	shan(7,"shan"),
	hindu(8,"hindu"),
	islam(9,"islam"),
	chinese(10,"chinese"),
	others(11,"others");
	private int id;
	private String name;
	 private Nationality(int id,String name) {
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
