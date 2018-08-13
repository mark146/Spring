package org.com.service;

import org.com.dto.LoginDTO;
import org.com.vo.UserVO;
import java.util.*;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void KeepLogin(String uid, String sessionId, Date next) throws Exception;
	
	public UserVO checkLoginBefore(String value);
}