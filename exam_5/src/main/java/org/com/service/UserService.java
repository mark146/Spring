package org.com.service;

import org.com.dto.LoginDTO;
import org.com.vo.UserVO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}