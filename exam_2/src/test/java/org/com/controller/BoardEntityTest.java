package org.com.controller;

import javax.inject.Inject;

import org.com.entity.IBoardEntity;
import org.com.vo.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardEntityTest {

	@Inject
	private IBoardEntity iEntity;

	private static Logger logger = LoggerFactory.getLogger(BoardEntityTest.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로운 글을 넣습니다.");
		vo.setContent("새로운 글을 넣습니다.");
		vo.setWriter("user00");
		iEntity.create(vo);
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(iEntity.read(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("수정된 글입니다.");
		vo.setContent("수정 테스트");
		iEntity.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception {
		iEntity.delete(1);
	}
	
}
