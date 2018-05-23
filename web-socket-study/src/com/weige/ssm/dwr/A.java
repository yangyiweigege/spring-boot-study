package com.weige.ssm.dwr;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A
 */
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A() {
    	System.out.println("调用了构造方法!!!!!");
    	//System.out.println("构造方法" + super.getServletConfig().getInitParameter("contextConfigLocation"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("调用初始化" + super.getServletConfig().getInitParameter("contextConfigLocation"));
		
	}

	/*@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("调用初始化 有参数");
	}*/

	
	
}
