package org.com.controller;

import java.text.DateFormat;
import java.util.*;
import org.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	private UserDetailsManager userDetailsManager;
	private PasswordEncoder passwordEncoder;
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
	
	@RequestMapping(value = "/user/memberForm", method = RequestMethod.GET)
	public void memberFormGET(@ModelAttribute("vo") UserVO vo) {
	}	
	
	@RequestMapping(value = "/user/memberForm", method = RequestMethod.POST)
	public String memberFormPOST(@ModelAttribute("vo") UserVO vo) {
		String password = passwordEncoder.encode(vo.getUpw());
		UserDetails user = new User(vo.getUid(), password, Arrays.asList(new SimpleGrantedAuthority("USER")));
		try {
			userDetailsManager.createUser(user);//이 메서드는 추가할 사용자를 UserDetails 타입으로 전달받는다.
			return "user/joinForm";
		} catch (DuplicateKeyException ex) {
			return "/";
		}
	}
}