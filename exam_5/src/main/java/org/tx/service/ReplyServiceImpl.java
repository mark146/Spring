package org.tx.service;

import java.util.List;

import javax.inject.Inject;
import org.tx.entity.*;
import org.tx.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements IReplyService{
	
	@Inject
	private IReplyEntity ire;
	
	@Inject
	private IBoardEntity ibe;
	
	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return ire.list(bno);
	}
	
	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		ire.create(vo);
		ibe.updateReplyCnt(vo.getBno(), 1);
	}
	
	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		ire.update(vo);
	}
	
	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {
		
		int bno = ire.getBno(rno);
		ire.delete(rno);
		ibe.updateReplyCnt(bno, -1);
	}
	
	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		return ire.listPage(bno, cri);
	}
	
	@Override
	public int count(Integer bno) throws Exception {
		return ire.count(bno);
	}
	
	
}
