package com.weige.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.weige.ssm.service.SchedualServiceHi;
@Service
public class SchedualServiceHiHystric implements SchedualServiceHi{

	@Override
	public String getHello(String name) {
		return "对不起 ,您所呼叫的服务暂时无法接通~~~参数：" + name;
	}

}
