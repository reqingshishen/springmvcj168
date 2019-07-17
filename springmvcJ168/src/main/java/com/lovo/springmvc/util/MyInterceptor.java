package com.lovo.springmvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	Logger log=Logger.getLogger(this.getClass());
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean bl=false;
		log.info("调用方法之前");
		//从session中获取用户对象，如果存在就放行，如果不存在就回到登录页面
	Object obj=	request.getSession().getAttribute("userObj");
	if(null!=obj) {
		bl=true;
	}else {
		//重定向到登陆页面
		response.sendRedirect("../page/login.jsp");
	}
		return bl;
	}

	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("调用方法之后");
		
	}

	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("视图渲染之后");
		
	}

}
