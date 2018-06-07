package com.weige.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.service.RedisService;

/**
 * <pre>
 * 功       能: 测试配置好的redis服务
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年5月14日 上午10:48:57
 * Q    Q: 2873824885
 * </pre>
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private RedisService redisService;
	

	@GetMapping("/template")
	public Result<Object> test() {
		Result<Object> result = new Result<Object>();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "杨乙伟");
		jsonObject.put("age", 26);
		redisTemplate.opsForValue().set("redis-test", "spring-boot");
		redisTemplate.opsForValue().set("information", jsonObject.toJSONString());
		result.setCode(ResultStatus.SUCCESS).setData(redisTemplate.opsForValue().get("information"));
		return result;
	}

	/**
	 * 执行redis事务
	 * @return
	 */
	@GetMapping("/transaction")
	public Result<Object> jedisTest() {
		Result<Object> result = redisService.execTransaction();
		return result;
	}
	
	
	
	/**
	 * 测试redis管道
	 * @return
	 */
	@RequestMapping(value = "/pipe", method = {RequestMethod.POST, RequestMethod.GET})
	public Result<Object> redisPipelined() {
		Result<Object> result = redisService.execPipeLined();
		return result;
	}
	
	/**
	 * redis hash操作设置
	 */
	
}
