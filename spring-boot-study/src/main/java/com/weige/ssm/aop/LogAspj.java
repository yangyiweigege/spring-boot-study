package com.weige.ssm.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 记录下所有的访问情况
 * 
 * @author yangyiwei
 * @date 2018年6月4日
 * @time 下午3:47:57
 */
//@Aspect
public class LogAspj {

	private final static Logger logger = Logger.getLogger(LogAspj.class);
	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private Jedis jedis;
	
	
	
	/**
	 * <pre>
	 * 功       能: 统一定义一个切面，复用
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月9日 上午9:42:27
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@Pointcut("execution(public * com.weige.ssm.controller.*.*(..))")
	public void logPointCut() {

	}

	@Before("logPointCut()")
	public void log(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// url
		logger.info("url = " + request.getRequestURI());
		// ip
		logger.info("ip = " + request.getRemoteAddr());
		// 类方法
		logger.info("class : " + joinPoint.getSignature().getDeclaringTypeName() + " method:"
				+ joinPoint.getSignature().getName());
		// 参数
		logger.info("agr :" + joinPoint.getArgs());
	}

	@AfterReturning(value = "logPointCut()", returning = "object")
	public void getId(Object object) {
		String json = JSONObject.toJSONString(object);
		logger.info(json);
	//	jedis.lpush("spring_boot_log", json);
	}
}
