package com.miniproject2.study.interceptor.LoginCheckInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor  implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
	HttpServletResponse response, Object handler) throws Exception {
	// 세션에 isLogin란 이름의 데이터가 없으면 로그인 상태가 아님
	if(request.getSession().getAttribute("isLogin") == null) {
	response.sendRedirect("loginForm");
	return false;
	}
	return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
	HttpServletResponse response, Object handler,
	ModelAndView modelAndView) throws Exception {
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
	HttpServletResponse response, Object handler, Exception ex)
	throws Exception {
	}

}
