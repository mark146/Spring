package org.upload.cotroller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	private static Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value= "/uploadForm", method= RequestMethod.GET)
	public void uploadFormGet() {
		logger.info("GET 방식");
	}
	
	@RequestMapping(value= "/uploadForm",method= RequestMethod.POST)
	public String uploadFormPOST(MultipartFile file, Model model) throws Exception {
		logger.info("POST 방식");
		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());
		
		String savedName = 
				uploadFile(file.getOriginalFilename(), file.getBytes());
		
		model.addAttribute("savedName", savedName);
		
		return "uploadResult";
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath,savedName);
		
		FileCopyUtils.copy(fileData, target);
		
 		return savedName;
	}
}