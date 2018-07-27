package org.com.service;

import javax.inject.Inject;

import org.com.entity.MessageEntity;
import org.com.entity.PointEntity;
import org.com.vo.MessageVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageEntity messageEntity;
	
	@Inject
	private PointEntity pointEntity;
	
	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		messageEntity.create(vo);
		pointEntity.updatePoint(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String uid, Integer mid) throws Exception {
		messageEntity.updateState(mid);
		pointEntity.updatePoint(uid, 5);
		return messageEntity.readMessage(mid);
	}
}