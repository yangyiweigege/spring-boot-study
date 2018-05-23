package com.weige.ssm.dwr;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeHtmlServlet
 */
public class ChangeHtmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeHtmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("调用servlet!");
		CopyOnWriteArraySet<MyWebSocket> webSocketSet = MyWebSocket.getAllSocket();
		for(MyWebSocket item: webSocketSet){               
            try {  
                item.sendMessage("服务器主动推送消息给用户！");  
            } catch (IOException e) {  
                e.printStackTrace();  
                continue;  
            }  
        }  
	}

}
