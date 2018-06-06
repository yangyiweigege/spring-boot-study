package com.weige.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 配置cors拦截
 * @author yangyiwei
 * @date 2018年6月4日
 * @time 上午10:17:45
 */
/**
 * CORS过滤器 完成跨域请求
 *  
 * @author yangyiwei
 *
 */
@WebFilter(filterName = "myCORSFilter", urlPatterns = "/*")
public class MyCORSFilter implements Filter {

	private final static Logger logger = Logger.getLogger(MyCORSFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// String origin = (String) servletRequest.getRemoteHost() + ":" +
		// servletRequest.getRemotePort();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		logger.info("执行了cors......" + "url = " + request.getRequestURI() + " 请求来自:" + request.getRemoteAddr());
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
