package org.ajax.entity;

import java.util.*;
import javax.inject.Inject;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.ajax.vo.*;

@Repository
public class ReplyEntityImpl implements IReplyEntity {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.ajax.mapper.ReplyMapper";
	
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		return session.selectList(namespace+".list", bno);
	}
	
	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}
	
	@Override
	public void delete(Integer rno) throws Exception {
		session.delete(namespace+".delete", rno);
	}
	
	
 }
