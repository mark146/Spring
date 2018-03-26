package org.tx.entity;

import org.tx.vo.*;

public interface IMessageEntity {

	public void create(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(Integer mid) throws Exception;
	
	public void updateState(Integer mid) throws Exception;
}
