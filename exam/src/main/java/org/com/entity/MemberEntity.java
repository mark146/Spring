package org.com.persistence;

import org.com.domain.*;

public interface MemberEntity {

		public String getTime();
		
		public void insertMember(MemberVO vo);
		
		public MemberVO readMember(String userid)throws Exception;
		
		public MemberVO readWithPW(String userid, String userpw)throws Exception;
}
