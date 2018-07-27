package org.com.entity;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.com.vo.MessageVO;
import org.springframework.stereotype.Repository;

@Repository
public class MessageEntityImpl implements MessageEntity {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.com.mapper.MessageMapper";
	
	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public MessageVO readMessage(Integer mid) throws Exception {
		return session.selectOne(namespace + ".readMessage", mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(namespace + ".updateState", mid);
	}
}