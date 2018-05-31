package com.weige.ssm.thread;

public class ThreadExceptionTest {
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 1 / 0;
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("第2条线程");
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("第3条线程");
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("第4条线程");
			}
		}).start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行完毕");
	}
}
