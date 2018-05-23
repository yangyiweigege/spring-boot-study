package com.weige.ssm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.domain.User;
import com.weige.ssm.service.SchedualServiceHi;
import com.weige.ssm.service.UserService;

@RestController
@RequestMapping("/feign")
public class FeignController {

	@Autowired
	private SchedualServiceHi schedualServiceHi;
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name) {
		return schedualServiceHi.getHello(name) + "  result  from feign";
	}
	
	@RequestMapping(value = "/list/{currentPage}", method = {RequestMethod.GET,RequestMethod.POST})
	public JSONObject userList(User user, @PathVariable("currentPage")Integer currentPage) {
		JSONObject result = userService.findList(currentPage);
		return result;
	}

}
