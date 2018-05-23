package com.weige.ssm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class SpringMongodbTest extends SpringBootStudyApplicationTests{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private JedisPool jedisPool;
	
	@Test
	public void find() {
		Object object = mongoTemplate.findById("5abc77466efbea90edd10d15", Object.class, "demo");
		JSONObject.toJSONString(object);
	}
	
	@Test
	public void jedis() {
		Jedis jedis = jedisPool.getResource();
		jedis.select(15);
		jedis.hdel("jedis", "max");
	}
}
