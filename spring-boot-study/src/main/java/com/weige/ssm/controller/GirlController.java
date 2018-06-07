package com.weige.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weige.ssm.dao.GirlMapper;
import com.weige.ssm.domain.Girl;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.service.GirlServie;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * <pre>
 * 功       能: hibernate实现 
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月27日 下午10:37:23
 * Q    Q: 2873824885
 * </pre>
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

	// @Value("${cupSize}")
	// private String cupSize;
	@Autowired
	private GirlMapper girlMapper;
	@Autowired
	private GirlServie girlService;


	@ApiOperation(value = "查询女生情况")
	@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String")
	@RequestMapping(value = { "/say/{name}", "/speak" }, method = RequestMethod.GET)
	public Map<String, Object> sayHello(@PathVariable("name") String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("age", 15);
		return map;
	}

	/**
	 * <pre>
	 * 功       能:查询v女生 
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午3:56:14
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Girl> list() {
		return girlMapper.findAll();
	}

	/**
	 * <pre>
	 * 功       能:查询一个女生 
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午4:11:35
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Girl findGirlById(@PathVariable("id") Integer id) {
		return girlMapper.findOne(id);
	}

	/**
	 * <pre>
	 * 功       能: 添加一个女生
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午4:14:52
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@ApiOperation(value = "添加一个女生")
	@ApiImplicitParams(value ={@ApiImplicitParam(name = "girl", value = "女生信息", required = true, dataType = "String"),@ApiImplicitParam(name = "bindingResult", value = "参数校验结果", required = true, dataType = "bindingResult")})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {
		Result<Girl> result = new Result<Girl>();
		if (bindingResult.hasErrors()) {
			return result.setCode(ResultStatus.DEFINE_ERROR).setMessage(bindingResult.getFieldError().getDefaultMessage());
		}
		girlMapper.save(girl);
		return result.setCode(ResultStatus.SUCCESS).setData(girl);
	}

	/**
	 * <pre>
	 * 功       能: 删除
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午4:14:52
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deleteGirl(@PathVariable("id") Integer id) {
		girlMapper.delete(id);
	}

	/**
	 * <pre>
	 * 功       能: 更新
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午4:14:52
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@PutMapping(value = "/update")
	public Girl updateGirl(Girl gril) {
		return girlMapper.save(gril);
	}

	/**
	 * <pre>
	 * 功       能:通过年龄来查询
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午4:11:35
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@RequestMapping(value = "/find/age/{age}", method = RequestMethod.GET)
	public List<Girl> findGirlByAge(@PathVariable("age") Integer age) {
		return girlMapper.findByAge(age);
	}

	/**
	 * <pre>
	 * 功       能:插入
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月8日 下午4:11:35
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@GetMapping("/insert/two")
	public void insertTwo() {
		girlService.insertTwo();
	}

	@RequestMapping(value = "/judge/age/{id}")
	public Result<Object> judgeGirlAge(@PathVariable("id") Integer id) throws Exception {
		Result<Object> result = girlService.judgeGirlAge(id);
		return result;

	}

}
