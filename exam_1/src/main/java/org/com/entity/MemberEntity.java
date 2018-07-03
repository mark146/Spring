package org.com.entity;

import org.com.vo.MemberVO;

public interface MemberEntity {

	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
