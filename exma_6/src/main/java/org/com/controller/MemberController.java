package org.com.controller;

import javax.inject.Inject;

import org.com.service.MemberService;
import org.com.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/memberForm", method = RequestMethod.GET)
	public void memberFormGET(@ModelAttribute("vo") UserVO vo) {
	}	
	
	@RequestMapping(value = "/memberForm", method = RequestMethod.POST)
	public String memberFormPOST(@ModelAttribute("vo") UserVO vo) {
		
		try {
			memberService.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";

	}
}
