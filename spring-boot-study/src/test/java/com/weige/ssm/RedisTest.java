package com.weige.ssm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.service.RedisService;

public class RedisTest  extends SpringBootStudyApplicationTests{
	
	@Autowired
	private RedisService redisService;
	
	
	@Test
	public  void buy() {
		for (int i = 0; i < 40; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(JSONObject.toJSONString(redisService.highKill()));
				}
			}).start();
		}
	}

}
