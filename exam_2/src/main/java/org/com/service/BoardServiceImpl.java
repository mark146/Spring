package org.com.service;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.IBoardEntity;
import org.com.vo.BoardVO;
import org.com.vo.Criteria;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements IBoardService{

	@Inject
	private IBoardEntity ibe;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		ibe.create(vo);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
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
	public List<BoardVO> listAll() throws Exception {
		return ibe.listAll();
	}
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		return ibe.listPage(page);
	}
	

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return ibe.listCriteria(cri);
	}
	
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return ibe.countPaging(cri);
	}
}
