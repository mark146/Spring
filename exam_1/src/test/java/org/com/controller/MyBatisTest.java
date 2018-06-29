package org.com.controller;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
//위 애노테이션은 현재 테스트 코드를 실행할 때 스프링이 로딩되도록 하는 부분이다.
public class MyBatisTest {

	@Inject//스프링이 생성해서 주입해 주므로 생성 및 다른작업을 하지 않아도 된다.
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	@Test
	public void testConnection() throws Exception {
		try(SqlSession session = sqlFactory.openSession()) {
			System.out.println(session);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
