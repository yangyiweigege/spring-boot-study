package com.weige.en.test;

public enum Color {
	RED, GREEN, BLANK, YELLOW  ;
	private String name;
	private String value;
	private Color() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
