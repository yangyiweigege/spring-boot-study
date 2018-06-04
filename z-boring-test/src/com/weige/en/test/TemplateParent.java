package com.weige.en.test;

import java.io.Serializable;
import java.util.List;



public abstract class TemplateParent<T, PK extends Serializable> {
	private T entify;
	private PK id;
	
	public TemplateParent() {
		
	}

	public T getEntify() {
		return entify;
	}

	public void setEntify(T entify) {
		this.entify = entify;
	}

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
	
	public T getData() {
		return entify;
	}
	
	public void setData(T data) {
		this.entify = data;
	}
	
	public abstract T findById(PK id);
	
	public static <A> List<A>  template(Class<A> a) {
		return null;
	}
	
	public static void main(String[] args) {
		//List<Servlet> list = TemplateParent.template(Servlet.class);
		int a[][] = {{1,2,3,4},{5,6,7,8}};
		for (int i = 0; i < a.length; i++) {
			int b[] = a[i];
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[j] + "  ");
			}
		}
	}
	

}
