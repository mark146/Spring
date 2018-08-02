package org.com.service;

import java.util.List;

import javax.inject.Inject;
import org.com.entity.*;
import org.com.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyEntity replyEntity;

	@Inject
	private BoardEntity boardEntity;

	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		replyEntity.create(vo);
		boardEntity.updateReplyCnt(vo.getBno(), 1);
	}
	
	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return replyEntity.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		replyEntity.update(vo);
	}
	
	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {
		int bno = replyEntity.getBno(rno);
		replyEntity.delete(rno);
		boardEntity.updateReplyCnt(bno, -1);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		return replyEntity.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return replyEntity.count(bno);
	}
}
