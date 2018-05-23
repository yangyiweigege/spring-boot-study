package com.weige.ssm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weige.ssm.domain.Girl;

public interface GirlMapper extends JpaRepository<Girl, Integer> {
	
	/**
	 * <pre>
	 * 功       能: 年龄查询
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午4:41:38
	 * Q    Q: 2873824885
	 * </pre>
	 */
	public List<Girl> findByAge(Integer age);

}
