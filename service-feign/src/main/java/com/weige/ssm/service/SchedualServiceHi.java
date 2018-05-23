package com.weige.ssm.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weige.ssm.service.impl.SchedualServiceHiHystric;
/**
 * <pre>
 * 功       能: 使用feign负载均衡
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年4月23日 上午9:36:05
 * Q    Q: 2873824885
 * </pre>
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

	@RequestMapping(value = "/hi")
	public String getHello(@RequestParam(value = "name") String name);
	
}
