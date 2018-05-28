package com.weige.ssm.thread;

public class DeaLockTest {

	public static void main(String[] args) {
		DeadLockObject deadLockObject = new DeadLockObject();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				deadLockObject.lockOne();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				deadLockObject.lockTwo();
			}
		}).start();
	}
}
