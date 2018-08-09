package org.com.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.*;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.*;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("post handle...");
		Object result = modelAndView.getModel().get("result");
		
		if(result != null) {
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/doA");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		System.out.println("pre handle...");
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		System.out.println("Bean: " + method.getBean());
		System.out.println("Method: " + methodObj);
		return true;
	}
}
