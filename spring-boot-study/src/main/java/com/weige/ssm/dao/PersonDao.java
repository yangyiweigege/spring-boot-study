package com.weige.ssm.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.weige.ssm.domain.Person;

public interface PersonDao extends  MongoRepository<Person, Integer>{
	
	//@Cacheable(value = "person", keyGenerator = "keyGenerator") 此方法可以采用自定义生成策略 
	@Cacheable(value="user", key="'users_'+#p0")
	public Person findOne(Integer id); 
	
	 /** 
     * 新增或修改时 
     */  
    @CachePut(value = "user", key = "'users_'+#p0.id")  
	public Person insert(Person person);
    
    /**
     * 删除key的时候
     */
    @CacheEvict(value="user", key="'users_'+#p0") 
    public void delete(Integer id);
}
