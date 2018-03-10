package org.ajax.service;

import java.util.List;

import javax.inject.Inject;
import org.ajax.entity.*;
import org.ajax.vo.*;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements IReplyService{
	
	@Inject
	private IReplyEntity ire;
	
	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return ire.list(bno);
	}
	
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		ire.create(vo);
	}
	
	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		ire.update(vo);
	}
	
	@Override
	public void removeReply(Integer rno) throws Exception {
		ire.delete(rno);
	}
}
