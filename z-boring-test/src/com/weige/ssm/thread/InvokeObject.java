package com.weige.ssm.thread;

import java.util.concurrent.locks.Lock;

public class InvokeObject {

	public  void get(Lock lock) {
		synchronized (StaticLock.L_O_C_K) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "调用了该方法!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public  void set(Lock lock) {
		synchronized (StaticLock.L_O_C_K) {
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "类被锁住了");
		}
		}
	}
}
