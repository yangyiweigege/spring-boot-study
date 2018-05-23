package com.weige.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
	private JedisPool jedisPool;
	

	@GetMapping("/test")
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

	@GetMapping("/client")
	public Result<Object> jedisTest() {
		Result<Object> result = new Result<Object>();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "杨乙伟");
		jsonObject.put("age", 26);
		Jedis jedis = jedisPool.getResource();
		jedis.select(15);
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("max", "10");
		attribute.put("min", "5");
		attribute.put("timeout", "10");
		jedis.hmset("redis-attribute", attribute);
		jedis.close();
		return result.setCode(ResultStatus.SUCCESS).setData(attribute);
	}

}
