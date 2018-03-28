package org.tx.controller;

import java.util.*;
import javax.inject.Inject;

import org.tx.service.IReplyService;
import org.tx.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private IReplyService irs;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) {

		ResponseEntity<String> entity = null;

		try {
			irs.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);		
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno) {

		ResponseEntity<List<ReplyVO>> entity = null;
		System.out.println(bno);

		try {
			entity = new ResponseEntity<>(
					irs.listReply(bno), HttpStatus.OK);
			System.out.println(entity);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value="/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(
			@PathVariable("rno") Integer rno,
			@RequestBody ReplyVO vo) {

		ResponseEntity<String> entity = null;

		try {
			vo.setRno(rno);
			irs.modifyReply(vo);

			entity = new ResponseEntity<String> ("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value="/{rno}", method= RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno) {
		ResponseEntity<String> entity = null;
		
	try {
		irs.removeReply(rno);
		entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		entity = new ResponseEntity<String>("SUCCESS",HttpStatus.BAD_REQUEST);
	}
	
	return entity;
	}
	
	@RequestMapping(value="/{bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable("bno")  Integer bno,
			@PathVariable("page")  Integer page) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pm = new PageMaker();
			pm.setCri(cri);
			
			Map<String,Object> map = new HashMap<String, Object>();
			List<ReplyVO> list = irs.listReplyPage(bno, cri);
			
			map.put("list", list);
			
			int replyCount = irs.count(bno);
			pm.setTotalCount(replyCount);
			
			map.put("pageMaker", pm);
			
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
}
