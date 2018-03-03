package org.com.controller;


import javax.inject.Inject;

import org.com.service.IBoardService;
import org.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private IBoardService ibs;

	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET(BoardVO vo, Model model) throws Exception {
		logger.info("register get..");//항상 사용자가 직접 브라우저에서 접근이 가능할 때 사용
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("regist post ..");//항상 외부에서 많은 정보를 입력하는 경우에 사용
		logger.info(vo.toString());

		ibs.regist(vo);

		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listPage";
	}
	
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")Criteria cri,
			Model model) throws Exception {
		logger.info(cri.toString());

		model.addAttribute("list", ibs.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(ibs.listCountCriteria(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

		
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,
			@ModelAttribute("cri") Criteria cri, 
			Model model) throws Exception {
		logger.info("show read..");
		model.addAttribute(ibs.read(bno));
	}


	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, 
			Criteria cri,
			RedirectAttributes rttr) throws Exception {
		logger.info("show remove..");

		ibs.remove(bno);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listPage";
	}


	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno,
			@ModelAttribute("cri") Criteria cri, 
			Model model) throws Exception {
		logger.info("show modifyGET..");
		model.addAttribute(ibs.read(bno));
	}

	
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPOST(BoardVO vo,Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("show modifyPOST..");

		ibs.modify(vo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
}
