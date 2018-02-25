package org.com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.com.domain.ProductVO;

@Controller
public class SampleController2 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);

	@RequestMapping("/exam2")
	public String exam2(Model model) {

		ProductVO product = new ProductVO("Sample Product",10000);

		logger.info("exam2");

		model.addAttribute(product);

		return "productDetail";
	}

}
