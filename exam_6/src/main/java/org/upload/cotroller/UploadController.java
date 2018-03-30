package org.upload.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UploadController {

	private static Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value= "/uploadForm", method= RequestMethod.GET)
	public void uploadForm() {
		
	}
	
}
