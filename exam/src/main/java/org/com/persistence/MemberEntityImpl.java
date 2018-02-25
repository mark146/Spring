package org.com.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.com.domain.MemberVO;

@Repository
public class MemberEntityImpl implements IMemberEntity {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.com.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);
	}
}
