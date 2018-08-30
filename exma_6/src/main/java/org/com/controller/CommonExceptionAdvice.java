package org.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("org.com")
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView error(Exception e) {
		logger.info(e.toString());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error/500");
		modelAndView.addObject("exception", e);
		return modelAndView;
	}
}