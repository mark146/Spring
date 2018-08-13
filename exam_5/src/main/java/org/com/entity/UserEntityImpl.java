package org.com.entity;

import java.util.*;
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

	@Override
	public void keepLogin(String uid, String sessionId, Date next) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		session.update(namespace + ".KeepLogin", paramMap);
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) {
		return session.selectOne(namespace + ".checkUserWithSessionKey", value);
	}
}