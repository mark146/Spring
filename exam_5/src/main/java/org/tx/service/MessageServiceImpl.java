package org.tx.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tx.entity.*;
import org.tx.vo.*;

@Service
public class MessageServiceImpl implements IMessageService {

	@Inject
	private IMessageEntity ime;
	
	@Inject
	private IPointEntity ipe;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		System.out.println("addMessage service");
		ime.create(vo);
		ipe.updatePoint(vo.getSender(), 10);
	}
	
	@Override
	public MessageVO readMessage(String uid, Integer mid) throws Exception {
		ime.updateState(mid);
		ipe.updatePoint(uid, 5);
		
		return ime.readMessage(mid);
	}
}
