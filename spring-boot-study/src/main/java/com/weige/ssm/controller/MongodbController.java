package com.weige.ssm.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.weige.ssm.domain.Person;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.plungin.ValidatePage;
import com.weige.ssm.service.PersonService;

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
	private PersonService personService;

	/**
	 * 新增一个人
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/insert", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> insert(Person person) {
		Result<Object> result = new Result<Object>();
		personService.insert(person);
		return result.setCode(ResultStatus.SUCCESS).setData(person);
	}

	/**
	 * 删除一个人
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<Object> delete(@PathVariable("id") Integer id) {
		Result<Object> result = personService.delete(id);
		return result.setCode(ResultStatus.SUCCESS).setData(id);
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<Object> update(@Valid Person person, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new Result<Object>().setCode(ResultStatus.LACK_PARAM)
					.setMessage(bindingResult.getFieldError().getDefaultMessage());
		}
		Result<Object> result = personService.update(person);
		return result;
	}

	@RequestMapping(value = "/find/all", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<Object> findAll() {
		Result<Object> result = personService.findAll();
		return result;
	}

	@RequestMapping(value = "/find/detail/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<Object> findById(@PathVariable("id") Integer id) {
		Result<Object> result = personService.findById(id);
		return result;
	}

	@RequestMapping(value = "/find/page", method = { RequestMethod.GET, RequestMethod.POST })
	@ValidatePage
	public Result<Object> findByPage(Integer pageSize, Integer pageNo) {
		Result<Object> result = personService.findByPage(pageSize, pageNo);
		return result;
	}
}
