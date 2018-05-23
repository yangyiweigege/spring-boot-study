package com.weige.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.domain.User;
import com.weige.ssm.service.UserService;

/**
 * 控制(MyBatis整合)
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

//	private final static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Value("${server.port}")
	private String port;

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<Object> saveUser(User user) throws Exception {
		Result<Object> result = userService.save(user);
		return result;
	}

	@RequestMapping(value = "/list/{currentPage}", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<Object> userList(User user, @PathVariable("currentPage") Integer currentPage) {
		Result<Object> result = userService.findList(user, currentPage);
		return result;
	}

	@RequestMapping(value = "/find/attribute", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<List<User>> findByAttribute(String user) {
		return userService.findByAttribute(user);
	}
	
	/**
	 * <pre>
	 * 功       能: 使用了缓存
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年5月3日 下午3:19:11
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@RequestMapping(value = "/find/detail/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<Object> findById(@PathVariable("id") String id) {
		Result<Object> result = new Result<Object>();
		return result.setCode(ResultStatus.SUCCESS).setData(userService.findById(id));
	}
	

	@RequestMapping(value = "/find/name/{name}", method = { RequestMethod.GET, RequestMethod.POST })
	public Result<Object> findByName(User user, @PathVariable("name") String name) {
		Result<Object> result = userService.findByName(name);
		return result;
	}
}
