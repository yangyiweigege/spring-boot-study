package com.weige.ssm.vali;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicDemo implements Runnable {
	/*private int serialNumber = 0;

	public void run() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {

		}

		System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
	}

	public int getSerialNumber() {
		return ++serialNumber;
	}*/
	
	private AtomicInteger serialNumber = new AtomicInteger();

    public void run(){
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){

        }

        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }

    public int getSerialNumber(){
        // 自增运算
        return serialNumber.getAndIncrement();
    }
}
