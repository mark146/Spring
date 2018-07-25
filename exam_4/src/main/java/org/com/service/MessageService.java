package org.com.service;

import org.com.vo.MessageVO;

public interface MessageService {

	public void addMessage(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(String uid, Integer mid) throws Exception;

}