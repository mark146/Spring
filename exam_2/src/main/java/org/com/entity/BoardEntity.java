package org.com.entity;

import java.util.List;

import org.com.vo.BoardVO;

public interface BoardEntity {

	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
}
