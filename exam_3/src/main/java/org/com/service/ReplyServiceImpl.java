package org.com.service;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.ReplyEntity;
import org.com.vo.Criteria;
import org.com.vo.ReplyVO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyEntity entity;

	@Override
	public void addReply(ReplyVO vo) throws Exception {
		entity.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return entity.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		entity.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		entity.delete(rno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		return entity.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return entity.count(bno);
	}
}
