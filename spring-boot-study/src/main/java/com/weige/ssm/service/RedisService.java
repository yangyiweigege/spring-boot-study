package com.weige.ssm.service;

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

}
