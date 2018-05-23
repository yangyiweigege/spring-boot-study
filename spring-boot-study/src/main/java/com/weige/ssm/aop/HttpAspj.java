package com.weige.ssm.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <pre>
 * 功       能: 面向aop切面编程 基于动态代理实现
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月9日 上午11:28:49
 * Q    Q: 2873824885
 * </pre>
 */
@Aspect
@Component
public class HttpAspj {
	
	private final static Logger logger = Logger.getLogger(HttpAspj.class);
	
	/**
	 * <pre>
	 * 功       能: 统一定义一个切面，复用
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月9日 上午9:42:27
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@Pointcut("execution(public * com.weige.ssm.controller.UserController.*(..))")
	public void logPointCut() {
		
	}
	
	@Before("logPointCut()")
	public void log(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url = " + request.getRequestURI());
		//ip
		logger.info("ip = " + request.getRemoteAddr());
		//类方法
		logger.info("class : " + joinPoint.getSignature().getDeclaringTypeName() + " method:" + joinPoint.getSignature().getName());
		//参数
		logger.info("agr :" + joinPoint.getArgs());
	}
	
	//@Before(value = "execution(public * com.weige.ssm.controller.GrilController.findGirlById(*))")
	public void beforeFindById(JoinPoint joinPoint) {
		System.out.println("查询方法执行前");
		Object[] objects = joinPoint.getArgs();
		System.out.println("方法类型: " + joinPoint.getTarget().getClass().getName());
		for (Object object : objects) {
			System.out.println("获取的参数" + object);
		}
	
	}
	
	
	/*@AfterReturning(value = "execution(public * com.weige.ssm.controller.GrilController.findGirlById(..))", returning = "girl")
	public void getId(Girl girl) {
		logger.info("这是我的日志输出====");
		System.out.println("执行方法后，查询得到的数据:" + girl.toString());
	}*/
}
