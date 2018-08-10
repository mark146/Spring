package org.com.entity;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.com.dto.LoginDTO;
import org.com.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityImpl implements UserEntity {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.com.mapper.UserMapper";
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}
}