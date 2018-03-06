package com.org.net;


import org.com.vo.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import javax.inject.Inject;
import org.com.entity.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardEntityTest2 {
	private static final Logger logger = LoggerFactory.getLogger(BoardEntityTest2.class);
	
	@Inject
	private IBoardEntity ibe;
	
	@Test
	public void testDynamic()  throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("글");
		cri.setSearchType("t");
		
		logger.info("===================================================");		
		
		List<BoardVO> list = ibe.listSearch(cri);
		
		for (BoardVO vo : list) {
			logger.info(vo.getBno()+": "+vo.getTitle());
		}
		
		logger.info("===================================================");		
		
		logger.info("COUNT: "+ibe.listSearchCount(cri));
	}
}
