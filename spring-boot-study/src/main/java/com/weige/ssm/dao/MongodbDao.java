package com.weige.ssm.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alibaba.fastjson.JSONObject;

public interface MongodbDao extends  MongoRepository<JSONObject, String>{

}
