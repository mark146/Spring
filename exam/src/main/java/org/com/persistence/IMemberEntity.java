package org.com.persistence;

import org.com.domain.*;

public interface IMemberEntity {

		public String getTime();
		
		public void insertMember(MemberVO vo);
		
		public MemberVO readMember(String userid)throws Exception;
		
		public MemberVO readWithPW(String userid, String userpw)throws Exception;
}
