package com.weige.ssm.thread;

public class MyTask implements Runnable {
	private int taskNum;

	public MyTask(int num) {
		this.taskNum = num;
	}

	@Override
	public void run() {

		System.out.println("正在执行task " + taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");

	}

	public void show() {
		System.out.println("调用！！！");
	}

	public static void main(String[] args) {
		/*
		 * MyTask myTask = new MyTask(1); new Thread(myTask).start();
		 * myTask.show();
		 */
	}

}
