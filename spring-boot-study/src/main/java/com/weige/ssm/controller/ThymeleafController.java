package com.weige.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * <pre>
 * 功       能: 配置thymeleaf模板
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年5月14日 上午10:48:57
 * Q    Q: 2873824885
 * </pre>
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	@RequestMapping("/index")
	public String thy() {
		return "/thymeleaf/index";
	}
}
