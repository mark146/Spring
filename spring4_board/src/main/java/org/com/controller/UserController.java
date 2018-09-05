package org.com.controller;
import javax.inject.Inject;
import javax.servlet.http.*;
import org.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.com.event.LoginEvent;
import org.com.event.LogoutEvent;
import org.com.exception.AuthenticationException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.com.validator.LoginCommandValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String LOGIN_FORM = "user/login";
	@Inject ApplicationEventPublisher publisher;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public void loginGET(@ModelAttribute("vo") UserVO vo) {
		logger.info("loginGET");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPOST(@ModelAttribute("vo") @Validated UserVO vo, Errors errors, HttpSession session, HttpServletRequest request) throws Exception {
		if (errors.hasErrors()) {
			return LOGIN_FORM;
		}
		logger.info("loginPOST");
		try {
			session.setAttribute("login", vo);
		    this.publisher.publishEvent(new LoginEvent(request.getContextPath()));
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
	        this.publisher.publishEvent(new LogoutEvent(request.getContextPath()));
			session.removeAttribute("login");
			session.invalidate();
		}
		
		return "redirect:/";
	}
}