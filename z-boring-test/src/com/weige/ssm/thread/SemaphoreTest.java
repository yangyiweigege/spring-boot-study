package com.weige.ssm.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	private Semaphore semaphore = new Semaphore(5, true);
	
	public void show() {
		try {
			semaphore.acquire();
			System.out.println("我获得了锁，执行==");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SemaphoreTest test = new SemaphoreTest();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					test.show();
					
				}
			}).start();
		}
	}
}
