package com.weige.ssm.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.domain.Result;

/**
 * redis操作
 * @author yangyiwei
 * @date 2018年6月7日
 * @time 上午9:33:02
 */
public interface RedisService {

	/**
	 * 测试redis事务
	 * @return
	 */
	public Result<Object> execTransaction();
	
	/**
	 * 测试redis管道
	 * @return
	 */
	public Result<Object> execPipeLined();

	/**
	 * 执行redis hash操作
	 * @param jsonObject
	 * @return
	 */
	public Result<Object> hashOperate(JSONObject jsonObject);

	/**
	 * 模拟多线程秒杀
	 * @return
	 */
	public Result<Object> highKill();

	/**
	 * 模拟分布式锁
	 * @return
	 */
	public Result<Object> distributeLock();

	/**
	 * redis数组操作
	 * @param jsonArray
	 * @return
	 */
	public Result<Object> listOperate(JSONArray jsonArray);

}
