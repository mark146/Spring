package org.tx.service;

import java.util.*;
import javax.inject.Inject;
import org.tx.entity.*;
import org.tx.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements IBoardService{

	@Inject
	private IBoardEntity ibe;

	@Override
	public void regist(BoardVO vo) throws Exception {
		ibe.create(vo);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(Integer bno) throws Exception {
		ibe.updateViewCnt(bno);
		return ibe.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		ibe.update(vo);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		ibe.delete(bno);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return ibe.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return ibe.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return ibe.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return ibe.listSearchCount(cri);
	}

}
