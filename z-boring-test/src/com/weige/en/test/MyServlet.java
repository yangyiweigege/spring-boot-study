package com.weige.en.test;

public class MyServlet extends Servlet{
	private int i = 10;
	
	public MyServlet() {
		System.out.println("调用了构造方法" + i);
	}
	
	public void init() {
		System.out.println("集成了一波无参数 initn" + i);
	}
	
	
	public static void main(String[] args) {
		new MyServlet();
	}
	
}
