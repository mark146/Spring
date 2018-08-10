package org.com.entity;

import org.com.dto.*;
import org.com.vo.*;

public interface UserEntity {
	public UserVO login(LoginDTO dto) throws Exception;
}
