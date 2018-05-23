package com.weige.ssm;

import org.junit.Test;

import com.weige.ssm.jms.LogProducer;
import org.springframework.beans.factory.annotation.Autowired;

public class JavaMessageSendTest extends SpringBootStudyApplicationTests{
	@Autowired
	private LogProducer logProducer;
	
	@Test
	public void sendMessage() {
		try {
			logProducer.run("大家好", "我是渣渣会");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
