package com.weige.ssm.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;

import com.alibaba.fastjson.JSONObject;
import com.weige.ssm.aop.ExceptionHandleAop;
import com.weige.ssm.domain.Result;
import com.weige.ssm.domain.ResultStatus;
import com.weige.ssm.plungin.ValidatePage;

/**
 * <pre>
 * 功       能:校验参数拦截器 
 * 涉及版本: V2.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2017年10月18日 下午6:38:34
 * Q     Q: 2873824885
 * </pre>
 */
public class ValidatePageInterceptor extends HandlerInterceptorAdapter {

	private final static Logger logger = Logger.getLogger(HandlerInterceptorAdapter.class);

	@SuppressWarnings("rawtypes")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			ValidatePage validate = method.getAnnotation(ValidatePage.class);
			if (validate != null) {
				logger.info("此方法存在 ValidatePage注解...进行分页参数校验中......");
				String pageNo = request.getParameter("pageNo");
				String pageSize = request.getParameter("pageSize");
				// 校验拦截到的参数
				if (pageNo == null || pageSize == null) {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = null;
					try {
						Result resultUtil = new Result();
						resultUtil.setCode(ResultStatus.LACK_PARAM).setData("pageSize 或者 pageNo 不能为空");
						out = response.getWriter();
						out.write(JSONObject.toJSONString(resultUtil));
						out.flush();
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
						out.write("服务器异常!");
						out.flush();
						out.close();
					}
					return false;
				}
			}
		}
		return true;
	}

}