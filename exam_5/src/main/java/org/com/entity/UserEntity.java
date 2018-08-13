package org.com.entity;

import java.util.Date;
import org.com.dto.*;
import org.com.vo.*;

public interface UserEntity {
	
	public UserVO login(LoginDTO dto) throws Exception;

	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);

}
