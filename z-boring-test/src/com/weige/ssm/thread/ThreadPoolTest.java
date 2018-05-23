package com.weige.ssm.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	   public static void main(String[] args) {   
	         ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
	                 new ArrayBlockingQueue<Runnable>(5));
	          
	         for(int i=0;i<15;i++){
	             MyTask myTask = new MyTask(i);
	             executor.execute(myTask);
	             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数："+
	             executor.getQueue().size()+"，已执行完的任务数目："+executor.getCompletedTaskCount());
	         }
	         executor.shutdown();
	     }
	

}
