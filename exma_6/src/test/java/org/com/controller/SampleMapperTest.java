package org.com.controller;

import javax.inject.Inject;

import org.com.entity.SampleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class SampleMapperTest {

	private static final Logger logger = LoggerFactory.getLogger(SampleMapperTest.class);
	
	@Inject
	private SampleMapper mapper;
	
	@Test
	public void test() {
		logger.info("test = "+mapper.getClass().getName());
		logger.info("test1 = "+mapper.getTime());
	}
	
	@Test
	public void testMail() {
		String email = mapper.getEmail("user10", "user10");
		System.out.println(email);
	}
	
	@Test
	public void testUserName() {
		String name = mapper.getUserName("user10", "user10");
		System.out.println(name);
	}
}