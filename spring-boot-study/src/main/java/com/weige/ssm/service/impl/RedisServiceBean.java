package com.weige.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.service.RedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

@Service
public class RedisServiceBean implements RedisService {

	@Autowired
	private JedisPool jedisPool;

	@Override
	public Result<Object> execTransaction() {
		Result<Object> result = new Result<Object>();
		Jedis jedis = jedisPool.getResource();
		Transaction transaction = jedis.multi(); // 开启redis事务
		transaction.lpush("transaction-line", "10", "20", "30", "40", "50");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "yangyiwei");
		map.put("age", "20");
		map.put("address", "杭州盈网科技");
		transaction.hmset("exit-employee", map);
		transaction.hmget("exit-employee", "name", "age");
		transaction.brpop(10, "transaction-line");
		List<Object> transactionResult = transaction.exec(); // 提交redis事务
		jedis.disconnect();
		return result.setCode(ResultStatus.SUCCESS).setData(transactionResult);
	}

	@Override
	public Result<Object> execPipeLined() {
		Result<Object> result = new Result<Object>();
		long startTime = System.currentTimeMillis();// 获取当前时间
		Jedis jedis = jedisPool.getResource();
		Pipeline pipeline = jedis.pipelined(); // redis管道技术
		for (int i = 0; i < 1000; i++) {
			pipeline.lpush("pipe", "管道测试:" + i);
		}
		List<Object> list = pipeline.syncAndReturnAll();// 发送redis管道
		System.out.println(list.toString());
		jedis.disconnect();
		long endTime = System.currentTimeMillis();
		return result.setCode(ResultStatus.SUCCESS).setData("程序运行时间:" + (endTime - startTime));
	}

	@Override
	public Result<Object> hashOperate(JSONObject jsonObject) {
		Result<Object> result = new Result<Object>();
		Jedis jedis = jedisPool.getResource();
		Map<String, String> dataMap = new HashMap<>();
		for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
			System.out.println("key : " + entry.getKey() + " value :" + entry.getValue());
			dataMap.put(entry.getKey(), entry.getValue() + "");
		}
		jedis.hmset("spring-boot-hash", dataMap);
		jedis.hset("spring-boot-hash", "detail", jsonObject.toJSONString());
		List<String> list = jedis.hmget("spring-boot-hash", "name", "age", "detail");
		System.out.println("hmse返回的结果： " + list.toString());
		Map<String, String> redisHash = jedis.hgetAll("spring-boot-hash");
		// map遍历 采用内部类
		for (Map.Entry<String, String> entry : redisHash.entrySet()) {
			System.out.println("redis中key : " + entry.getKey() + " value :" + entry.getValue());
		}
		return result.setCode(ResultStatus.SUCCESS).setData(jsonObject);
	}

	@Override
	public Result<Object> highKill() {
		Result<Object> result = new Result<Object>();
		Jedis jedis = jedisPool.getResource();
		jedis.select(15);
		long num = jedis.incr("num");
		String buyResult = "";
		if (num < 20) {
			jedis.lpush("result_queen", num + "" + "线程名:" + Thread.currentThread().getName());
			buyResult = "购买成功了";
		} else {
			buyResult = "购买失败了";
		}
		jedis.close();
		return result.setCode(ResultStatus.SUCCESS).setData(buyResult);
	}

	@Override
	public Result<Object> distributeLock() {
		Result<Object> result = new Result<Object>();
		Jedis jedis = jedisPool.getResource();
		jedis.select(15);
		while (true) { // 没有锁 则一直等待 模拟分布式锁
			if (jedis.setnx("lock", "1") == 1) {// 如果获得锁，则执行
				jedis.expire("lock", 20);
				break;
			} else {
				try {
					System.out.println("没有获得锁，等待了，，，老铁");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " 获得了锁 并且顺利执行~~~~~~");
		jedis.del("lock");
		jedis.disconnect();
		return result.setCode(ResultStatus.SUCCESS).setData("执行完毕");
	}

	@Override
	public Result<Object> listOperate(JSONArray jsonArray) {
		Result<Object> result = new Result<Object>();
		Jedis jedis = jedisPool.getResource(); 
		String[] strings = new String[10];
		for (int i = 0; i < jsonArray.size(); i++) {
			strings[i] = jsonArray.getString(i);
		}
		jedis.lpush("data-queen", strings);
		List<String> list = jedis.brpop(10, "data-queen", "spring-log");
		return result;
	}

}
