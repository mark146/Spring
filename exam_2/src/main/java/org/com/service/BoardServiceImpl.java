package org.com.service;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.BoardEntity;
import org.com.vo.*;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardEntity entity;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		entity.create(vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return entity.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		entity.update(vo);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		entity.delete(bno);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return entity.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return entity.listSearchCount(cri);
	}
}