package com.weige.ssm.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截器
 * @author Administrator
 *
 */
public class OneInterceptor implements HandlerInterceptor
{

	/**渲染了视图以后执行*/
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		
		System.out.println("被 one 的afterCompletion 拦截 。。。。。。");
	}

	/**controller方法之后调用 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception
	{
		System.out.println("被 one 的postHandle 拦截 。。。。。。");
		
	}

	/**请求到来之前*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception
	{
		System.out.println("被 one 的preHandle 拦截 。。。。。。");
		return true;
	}

}
