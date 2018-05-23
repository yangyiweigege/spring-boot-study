package com.weige.ssm.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * <pre>
 * 功       能: 微服务
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年4月23日 下午1:57:28
 * Q    Q: 2873824885
 * </pre>
 */
@RestController
public class ClientController {
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi " + name + "  I am spring-cloud,from port:" + port;
	}
}
