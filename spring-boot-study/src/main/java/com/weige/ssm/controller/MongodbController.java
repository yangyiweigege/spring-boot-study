package com.weige.ssm.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;

/**
 * <pre>
 * 功       能: 测试配置好的mongdob服务
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年5月14日 上午10:48:57
 * Q    Q: 2873824885
 * </pre>
 */
@RestController
@RequestMapping("/mongodb")
public class MongodbController {
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/test", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> findAll() {
		Result<Object> result = new Result<Object>();
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.and("name").is("yangyiwei");
		query.addCriteria(criteria);
		//query.with(new Sort(Direction.DESC, ""));
		List<JSONObject> list = mongoTemplate.findAll(JSONObject.class, "array");
		return result.setCode(ResultStatus.SUCCESS).setData(list);
	}

	@RequestMapping(value = "/insert", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> insert() {
		Result<Object> result = new Result<Object>();
		Query query = new Query();
		query.addCriteria(new Criteria().and("name").is("yangyiwei"));
		Update update = new Update();
		Set<String> set = new HashSet<String>();
		set.add("yangxingyu");
		set.add("caoaimei");
		update.pushAll("parent", set.toArray());
		mongoTemplate.updateFirst(query, update, "array");
		return result.setCode(ResultStatus.SUCCESS);
	}
}
