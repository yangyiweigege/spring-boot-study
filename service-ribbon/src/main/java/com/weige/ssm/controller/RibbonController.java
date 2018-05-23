package com.weige.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String hi(@RequestParam String name) {
		System.out.println("已经进入到 ribbon内部");
		return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class) + "ribbon 返回的结果";
	}

	// 熔断之后 返回的错误
	public String hiError(String name) {
		return "hi," + name + ",您所呼叫的服务暂时无法接通~~~~~!";
	}

}
