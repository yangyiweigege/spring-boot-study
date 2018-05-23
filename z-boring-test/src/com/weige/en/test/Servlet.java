package com.weige.en.test;

public class Servlet {
	
	
	public Servlet() {
		init("杨哥");
	}
	
	public void init(String name) {
		System.out.println("name:" + name);
		init();
	}
	
	public void init() {
		System.out.println("无参数 initn");
	}
}
