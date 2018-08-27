package org.com.controller;

import java.text.DateFormat;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "index";
	}
	
	@RequestMapping(value = "/homeMain", method = RequestMethod.GET)
	public void homeMain() {
	}
	
	@RequestMapping(value = "/adminMain", method = RequestMethod.GET)
	public void adminMain() {
	}
	
	@RequestMapping(value = "/managerMain", method = RequestMethod.GET)
	public void managerMain() {
	}
	
	@RequestMapping(value = "/memberMain", method = RequestMethod.GET)
	public void memberMain() {
	}	
}