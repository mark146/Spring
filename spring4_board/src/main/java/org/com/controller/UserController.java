package org.com.controller;

import javax.servlet.http.*;
import javax.validation.Valid;
import org.com.vo.*;
import org.com.exception.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.com.validator.LoginCommandValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final String LOGIN_FORM = "user/login";

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public void loginGET(@ModelAttribute("vo") UserVO vo) {
		System.out.println("loginGET");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPOST(@ModelAttribute("vo") @Valid UserVO vo, Errors errors, HttpSession session) throws Exception {
		if (errors.hasErrors()) {
			return LOGIN_FORM;
		}
		System.out.println("loginPOST");
		try {
			session.setAttribute("login", vo);
			return "redirect:/";
		} catch (AuthenticationException ex) {
			errors.reject("invalidIdOrPassword");
			return LOGIN_FORM;
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("login");
		
		if(obj != null) {
			session.removeAttribute("login");
			session.invalidate();
		}
		
		return "redirect:/";
	}
}