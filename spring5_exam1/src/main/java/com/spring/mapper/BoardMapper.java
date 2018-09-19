package com.spring.mapper;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0 ")
	public List<BoardVO> getList();
	
	public void insert(BoardVO vo);
	
	public void insertSelectKey(BoardVO vo);

	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO vo);
}
