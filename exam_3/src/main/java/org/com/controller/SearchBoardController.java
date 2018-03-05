package org.com.controller;

import javax.inject.Inject;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.com.vo.*;
import org.com.service.*;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private IBoardService ibs;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());
		
		model.addAttribute("list",ibs.listCriteria(cri));
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		
		pm.setTotalCount(ibs.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pm);
	}
}
