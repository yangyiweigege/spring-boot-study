package com.weige.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.service.RedisService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

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
	 * 
	 * @return
	 */
	@GetMapping("/transaction")
	public Result<Object> jedisTest() {
		Result<Object> result = redisService.execTransaction();
		return result;
	}

	/**
	 * 测试redis管道
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pipe", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> redisPipelined() {
		Result<Object> result = redisService.execPipeLined();
		return result;
	}

	/**
	 * redis hash操作设置
	 */
	@ApiOperation(value = "将对象写入redis")
	@ApiImplicitParam(name = "jsonObject", value = "json对象", required = true, dataType = "Object")
	@RequestMapping(value = "/hash", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> haseOperate(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject.getClass().getName());
		System.out.println(jsonObject.toString());
		Result<Object> result = redisService.hashOperate(jsonObject);
		return result;
	}
	
	/**
	 * redis hash操作设置
	 */
	@ApiOperation(value = "redis的list操作")
	@ApiImplicitParam(name = "jsonArray", value = "要存入的队列数组", required = true, dataType = "Object")
	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> list(@RequestBody JSONArray jsonArray) {
		Result<Object> result = redisService.listOperate(jsonArray);
		return result;
	}


	/**
	 * redis模拟多线程并发访问，防止超卖
	 */
	@ApiOperation(value = "将对象写入redis")
	@ApiImplicitParam(name = "jsonObject", value = "json对象", required = true, dataType = "Object")
	@RequestMapping(value = "/second/kill", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> secondKill(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject.getClass().getName());
		System.out.println(jsonObject.toString());
		Result<Object> result = redisService.highKill();
		return result;
	}

	/**
	 * 模拟实现分布式锁
	 * 
	 * @return
	 */
	@ApiOperation(value = "模拟实现分布式锁")
	@RequestMapping(value = "/distribute/lock", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> distributeLock() {
		return redisService.distributeLock();
	}
}
