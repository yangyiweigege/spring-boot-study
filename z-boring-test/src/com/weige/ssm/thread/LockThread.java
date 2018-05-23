package com.weige.ssm.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockThread implements Runnable{

	public InvokeObject invokeObject = new InvokeObject();
	private Lock lock;
	
	public LockThread(InvokeObject invokeObject) {
		this.invokeObject = invokeObject;
	}
	
	public LockThread(Lock lock) {
		this.lock = lock;
	}
	
	@Override
	public synchronized void run() {
	
		invokeObject.get(lock);
	
	}
	
	
	public synchronized void afterabc() {
	
		for(int i = 0; i < 10; i++) {
			try {
				System.out.println("执行到当前方法");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void main(String[] args) {
		InvokeObject invokeObject = new InvokeObject();
		//Lock lock = new ReentrantLock();
		LockThread thread2 = new LockThread(invokeObject);
		new Thread(thread2).start();
		invokeObject.set(null);
		//thread2.afterabc();;
		//new Thread(new LockThread(lock)).start();
		//new Thread(new LockThread2(lock)).start();
		System.out.println("执行主线程结束");
	}

}
