package org.com.service;

import javax.inject.Inject;
import org.com.dto.LoginDTO;
import org.com.entity.UserEntity;
import org.com.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserEntity entity;
	
	@Override
	public UserVO login(LoginDTO dto)throws Exception {
		return entity.login(dto);
	}
}