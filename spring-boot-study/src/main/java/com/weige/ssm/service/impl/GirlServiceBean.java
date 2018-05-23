package com.weige.ssm.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.weige.ssm.dao.GirlMapper;
import com.weige.ssm.domain.Girl;
import com.weige.ssm.domain.Result;
import com.weige.ssm.service.GirlServie;

@Service
public class GirlServiceBean implements GirlServie {

	@Resource
	private GirlMapper girlMapper;
	
	
	@Override
	//@Transactional
	public void insertTwo() {
		Girl one = new Girl();
		one.setName("杨以为");
		one.setAge(5);
		//Girl two = new Girl();
		//two.setAge(30);
		girlMapper.save(one);
		//girlMapper.save(two);
	}

	@Override
	public Result<Object> judgeGirlAge(Integer id) throws Exception {
		return null;
	}

}
