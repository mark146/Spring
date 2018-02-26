package org.com.service;

import java.util.List;

import javax.inject.Inject;

import org.com.entity.IBoardEntity;
import org.com.vo.BoardVO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements IBoardService{

	@Inject
	private IBoardEntity iEntity;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		iEntity.create(vo);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return iEntity.read(bno);
	}
	
	@Override
	public void modify(BoardVO vo) throws Exception {
		iEntity.update(vo);
	}
	
	@Override
	public void remove(Integer bno) throws Exception {
		iEntity.delete(bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return iEntity.listAll();
	}
}
