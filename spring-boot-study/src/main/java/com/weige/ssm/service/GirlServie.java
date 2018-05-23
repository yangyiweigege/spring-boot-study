package com.weige.ssm.service;

import com.weige.ssm.domain.Result;

/**
 * <pre>
 * 功       能: 业务逻辑层接口
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月8日 下午4:47:49
 * Q    Q: 2873824885
 * </pre>
 */
public interface GirlServie {

	/**
	 * <pre>
	 * 功       能:插入两个女孩子 
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月9日 下午1:34:52
	 * Q    Q: 2873824885
	 * </pre>
	 */
	public void insertTwo();

	/**
	 * <pre>
	 * 功       能: 判断岁数
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月9日 下午1:35:02
	 * Q    Q: 2873824885
	 * </pre>
	 * @throws Exception 
	 */
	public Result<Object> judgeGirlAge(Integer id) throws Exception;

}
