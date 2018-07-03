package org.com.entity;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.com.vo.MemberVO;

@Repository
public class MemberEntityImpl implements MemberEntity {

	@Inject
	private SqlSession session;
	
	private static final String namespace="org.com.mapper.MemberMapper";
	
	@Override	
	public String getTime() {
		return session.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		session.insert(namespace + ".insertMember", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return (MemberVO)session.selectOne(namespace + ".insertMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String pw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", pw);
		
		return session.selectOne(namespace + ".readWithPW", paramMap);
	}
}
