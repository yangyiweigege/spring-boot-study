package com.weige.ssm.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		Transaction transaction = jedis.multi(); //开启redis事务
		transaction.lpush("transaction-line", "10", "20", "30", "40", "50");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "yangyiwei");
		map.put("age", "20");
		map.put("address", "杭州盈网科技");
		transaction.hmset("exit-employee", map);
		transaction.hmget("exit-employee", "name", "age");
		transaction.brpop(10, "transaction-line");
		List<Object> transactionResult = transaction.exec(); //提交redis事务
		jedis.disconnect();
		return result.setCode(ResultStatus.SUCCESS).setData(transactionResult);
	}

	@Override
	public Result<Object> execPipeLined() {
		Result<Object> result = new Result<Object>();
		long startTime = System.currentTimeMillis();// 获取当前时间
		Jedis jedis = jedisPool.getResource();
		Pipeline pipeline = jedis.pipelined();  //redis管道技术
		for (int i = 0; i < 1000; i++) {
			pipeline.lpush("pipe", "管道测试:" + i);
		}
		List<Object> list = pipeline.syncAndReturnAll();//发送redis管道
		System.out.println(list.toString());
		jedis.disconnect();
		long endTime = System.currentTimeMillis();
		return result.setCode(ResultStatus.SUCCESS).setData("程序运行时间:" + (endTime - startTime));
	}

}
