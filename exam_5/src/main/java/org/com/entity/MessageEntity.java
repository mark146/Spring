package org.com.entity;

import org.com.vo.MessageVO;

public interface MessageEntity {

	public void create(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(Integer mid) throws Exception;
	
	public void updateState(Integer mid) throws Exception;
	
}