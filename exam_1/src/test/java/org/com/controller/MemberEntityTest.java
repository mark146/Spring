package org.com.controller;

import javax.inject.Inject;

import org.com.entity.MemberEntity;
import org.com.vo.MemberVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberEntityTest {

	@Inject
	private MemberEntity entity;
	
	@Test
	public void testTime() throws Exception {
		System.out.println(entity.getTime());
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");
		entity.insertMember(vo);
	}
}
