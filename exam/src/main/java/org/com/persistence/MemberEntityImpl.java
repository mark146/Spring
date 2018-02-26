package org.com.persistence;

import java.util.HashMap;
import java.util.Map;

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
	
	@Override
	public MemberVO readMember(String userid)throws Exception {
		return (MemberVO)
				sqlSession.selectOne(namespace+".selectMember", userid);
	}
	
	@Override
	public MemberVO readWithPW(String userid, String pw) throws Exception {
		
		 Map<String, Object> paramMap = new HashMap<String, Object>();
		 
		 paramMap.put("userid", userid);
		 paramMap.put("userpw", pw);
		 
		 return sqlSession.selectOne(namespace+".readWithPW", paramMap);
		 
	}
}
