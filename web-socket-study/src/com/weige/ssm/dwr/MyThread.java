package com.weige.ssm.dwr;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public class MyThread  implements Runnable{

	@Override
	public void run() {
		int count = 0;
		while(count<20) {
			count++;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("30S推送一次！");
			CopyOnWriteArraySet<MyWebSocket> webSocketSet = MyWebSocket.getAllSocket();
			for(MyWebSocket item: webSocketSet){               
	            try {  
	                item.sendMessage("服务器主动推送消息给用户！");  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	                continue;  
	            }  
	        }  
		}
	}

}
