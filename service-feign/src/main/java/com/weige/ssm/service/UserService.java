package com.weige.ssm.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
/**
 * <pre>
 * 功       能: 用户业务逻辑层
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月28日 下午2:55:38
 * Q    Q: 2873824885
 * </pre>
 */
@FeignClient(value = "spring-boot-study/user")
public interface UserService {

	/**
	 * <pre>
	 * 功       能: 查询全部
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月28日 下午12:22:59
	 * Q    Q: 2873824885
	 * </pre>
	 * @param currentPage 
	 */
	@RequestMapping(value = "/list/{currentPage}")
	public JSONObject findList(@PathVariable("currentPage") Integer currentPage);
}
