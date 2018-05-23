package com.weige.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 功       能: 测试freemarker模板
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年4月8日 下午2:02:07
 * Q    Q: 2873824885
 * </pre>
 */
@Controller
@RequestMapping("/free/marker")
public class FreeMarkerController {
	
	@RequestMapping("/index")
	public ModelAndView index() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		return new ModelAndView("/freemarker/index", dataMap);
	}

}
