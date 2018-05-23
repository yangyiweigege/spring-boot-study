package com.weige.ssm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.weige.ssm.controller.GirlController;
import com.weige.ssm.service.GirlServie;
/**
 * <pre>
 * 功       能: 单元测试
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年4月4日 下午2:49:55
 * Q    Q: 2873824885
 * </pre>
 */
public class GirlServiceTest extends SpringBootStudyApplicationTests{
	@Autowired
	private GirlServie girlService;
	@Autowired
	private GirlController girlController;
	
	@Test
	public void insertTwo() {
		girlService.insertTwo();
	}
}
