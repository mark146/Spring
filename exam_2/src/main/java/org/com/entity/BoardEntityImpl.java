package org.com.entity;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.com.vo.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardEntityImpl implements BoardEntity {

	@Inject
	private SqlSession session;
	
	private static String namespace="org.com.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return  session.selectList(namespace + ".listAll");
	}
}
