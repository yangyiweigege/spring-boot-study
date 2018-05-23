package com.weige.ssm.thread;

import java.util.concurrent.locks.Lock;

public class LockThread2 implements Runnable{

	public InvokeObject invokeObject = new InvokeObject();
	private Lock lock;
	
	public LockThread2(InvokeObject invokeObject) {
		this.invokeObject = invokeObject;
		
	}
	
	public LockThread2(Lock lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
	
		invokeObject.set(lock);
	
	}
	
	

}
