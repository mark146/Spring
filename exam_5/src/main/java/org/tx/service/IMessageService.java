package org.tx.service;

import org.tx.vo.*;

public interface IMessageService {

	public void addMessage(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(String uid, Integer mno) throws Exception;
}
