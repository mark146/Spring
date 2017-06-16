package service;

import vo.*;
import entity.*;

public class BoardServiceImpl implements IBoardService {
	private BoardEntity be;

	public void setboardEntity(BoardEntity be) {
		this.be = be;
	}
	
	public void articleList(BoardVO vo) {
		be.articleList(vo);
	}

	public void write(BoardVO vo) {
		be.write(vo);
	}
	
	public void content(BoardVO vo) {
		be.content(vo);
	}
	
	public void updateGetArticle(BoardVO vo) {
		be.updateGetArticle(vo);
	}
	
	public void updateArticle(BoardVO vo) {
		be.updateArticle(vo);
	}
	
	public void delete(BoardVO vo) {
		be.delete(vo);
	}
}