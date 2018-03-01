package org.com.service;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.IBoardEntity;
import org.com.vo.BoardVO;
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
}
