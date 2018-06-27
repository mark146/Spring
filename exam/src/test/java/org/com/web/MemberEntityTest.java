package org.com.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.com.domain.MemberVO;
import org.com.persistence.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberEntityTest {
	
	@Inject
	private MemberEntity iEntity;
	
	@Test
	public void testTime()throws Exception {
		System.out.println(iEntity.getTime());
	}
	
	@Test
	public void testInsertMember()throws Exception {
		MemberVO vo = new MemberVO();
		vo.setUserid("USER00");
		vo.setUserpw("USER00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aa.com");
		
		iEntity.insertMember(vo);
		
	}
}
