package com.weige.ssm.thread;

public class DeadLockObject {

	public void lockOne() {
		synchronized (StaticLock.L_O_C_K) {
			System.out.println("进入了A锁");
			try {
				Thread.sleep(2000);
				synchronized (StaticLock.LOCK_ANATHOR) {
					System.out.println("执行成功");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void lockTwo() {
		synchronized (StaticLock.LOCK_ANATHOR) {
			System.out.println("进入了B锁");
			try {
				Thread.sleep(2000);
				synchronized (StaticLock.L_O_C_K) {
					System.out.println("执行成功");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
