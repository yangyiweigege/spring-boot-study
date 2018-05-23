package com.weige.ssm.dao;

import org.springframework.cache.annotation.Cacheable;

import com.weige.ssm.domain.User;
import com.weige.ssm.plungin.MyMapper;

public interface UserMapper extends MyMapper<User> {
	
	@Cacheable(value = "user")
	public User findByName(String userName);
}