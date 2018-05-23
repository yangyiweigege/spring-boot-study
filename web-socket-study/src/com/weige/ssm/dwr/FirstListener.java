package com.weige.ssm.dwr;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 第一个监听器
 * @author yangyiwei
 *
 */
public class FirstListener implements ServletContextListener {

	

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("监听器启动，定时任务开启！");
		String name = arg0.getServletContext().getInitParameter("name");
		System.out.println("参数是:" + name);
		//启动定时任务
		 //创建定时器对象
        //Timer t=new Timer();
        //在3秒后执行MyTask类中的run方法
        //t.schedule(new MyTask(), 10000);
		new Thread(new MyThread()).start();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		System.out.println("监听器销毁");
	}

}
