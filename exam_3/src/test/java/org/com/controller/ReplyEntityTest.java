package org.com.controller;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.*;
import org.com.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReplyEntityTest {
	@Inject
	private ReplyEntity entity;
	
	private static Logger logger = LoggerFactory.getLogger(ReplyEntity.class);

	@Test
	public void testCreate() throws Exception {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1);
		vo.setReplytext("댓글 테스트");
		vo.setReplyer("user00");
		entity.create(vo);
	}
	
//	@Test
//	public void testUpdate() throws Exception {
//		BoardVO vo = new BoardVO();
//		vo.setBno(1);
//		vo.setTitle("수정된 글입니다.");
//		vo.setContent("수정 테스트");
//		entity.update(vo);
//	}
//	
//	@Test
//	public void testDelete() throws Exception {
//		entity.delete(1);
//	}
//	
//	@Test
//	public void testListPage() throws Exception {
//		int page = 2;
//		
//		List<BoardVO> list = entity.listPage(page);
//		
//		for (BoardVO vo : list) {
//			logger.info(vo.getBno() + ":" + vo.getTitle());
//		}
//	}
}