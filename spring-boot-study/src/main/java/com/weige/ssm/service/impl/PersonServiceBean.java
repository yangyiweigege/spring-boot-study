package com.weige.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.weige.ssm.dao.PersonDao;
import com.weige.ssm.domain.Person;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.service.PersonService;

@Service
public class PersonServiceBean implements PersonService {

	@Resource
	private PersonDao personDao;
	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public int insert(Person person) {
		System.out.println(personDao.insert(person).toString());
		return 1;
	}

	@Override
	public Result<Object> delete(Integer id) {
		Result<Object> result = new Result<Object>();
		if (id == null) {
			return result.setCode(ResultStatus.LACK_PARAM).setData("id");
		}
		personDao.delete(id);
		return result.setCode(ResultStatus.SUCCESS);
	}

	@Override
	public Result<Object> update(Person person) {
		Result<Object> result = new Result<Object>();
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.and("_id").is(person.getId());
		query.addCriteria(criteria);
		Update update = new Update();
		if (person.getName() != null) {
			update.set("name", person.getName());
		}
		if (person.getAge() != null) {
			update.set("age", person.getAge());
		}
		mongoTemplate.updateFirst(query, update, Person.class);
		return result.setCode(ResultStatus.SUCCESS);
	}

	@Override
	public Result<Object> findAll() {
		Result<Object> result = new Result<Object>();
		List<Person> list = personDao.findAll();
		return result.setCode(ResultStatus.SUCCESS).setData(list);
	}

	@Override
	public Result<Object> findById(Integer id) {
		Result<Object> result = new Result<Object>();
		Person person = personDao.findOne(id);
		return result.setCode(ResultStatus.SUCCESS).setData(person);
	}

	@Override
	public Result<Object> findByPage(Integer pageSize, Integer pageNo) {
		Result<Object> result = new Result<Object>();
		Query query = new Query();
		query.skip((pageNo - 1) * pageSize).limit(pageSize);
		List<Person> list = mongoTemplate.find(query, Person.class);
		return result.setCode(ResultStatus.SUCCESS).setData(list);
	}

}
