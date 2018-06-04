package com.weige.ssm.service;

import com.weige.ssm.domain.Person;
import com.weige.ssm.domain.Result;

public interface PersonService {

	/**
	 * 插入人员
	 * @param person
	 * @return
	 */
	public int insert(Person person);

	/**
	 * 根据id删除
	 * @param id
	 * @return 
	 */
	public Result<Object> delete(Integer id);

	/**
	 * 根据id更新
	 * @param person
	 * @return
	 */
	public Result<Object> update(Person person);

	/**
	 * 查询所有人员
	 * @return
	 */
	public Result<Object> findAll();

	/**
	 * 根据id查询对应人员
	 * @param id
	 * @return
	 */
	public Result<Object> findById(Integer id);

	/**
	 * 分页查询数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Result<Object> findByPage(Integer pageSize, Integer pageNo);

}
