package org.ajax.service;

import java.util.List;

import org.ajax.vo.ReplyVO;

public interface IReplyService {

	public List<ReplyVO> listReply(Integer bno) throws Exception;
	
	public void addReply(ReplyVO vo) throws Exception;
	
	public void modifyReply(ReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
}
