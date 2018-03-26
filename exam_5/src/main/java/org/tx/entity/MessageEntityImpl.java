package org.tx.entity;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.tx.vo.*;

@Repository
public class MessageEntityImpl implements IMessageEntity {

	@Inject
	private SqlSession session;
	
	private static String namespace="org.tx.mapper.MessageMapper";

	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public MessageVO readMessage(Integer mid) throws Exception {
		return session.selectOne(namespace+".readMessage", mid);
	}
	
	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(namespace+".updateState", mid);
	}
}