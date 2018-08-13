package org.com.controller;

import java.util.*;
import javax.inject.Inject;
import javax.servlet.http.*;
import org.com.dto.LoginDTO;
import org.com.service.UserService;
import org.com.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	private UserService service;
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) { 
	}
	
	@RequestMapping(value="/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		UserVO vo = service.login(dto);
		
		if(vo == null) { return; }
		
		model.addAttribute("userVO", vo);
		
		if(dto.isUseCookie()) {
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			
			service.KeepLogin(vo.getUid(), session.getId(), sessionLimit);
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		Object obj = session.getAttribute("login");
		
		if(obj != null) {
			UserVO vo = (UserVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.KeepLogin(vo.getUid(), session.getId(), new Date());
			}
		}
		
		return "user/logout";
	}
}
