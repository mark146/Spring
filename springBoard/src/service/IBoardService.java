package service;

import vo.*;

public interface IBoardService {
	public void articleList(BoardVO vo);
	public void write(BoardVO vo);
	public void content(BoardVO vo);
	public void updateGetArticle(BoardVO vo);
	public void updateArticle(BoardVO vo);
	public void delete(BoardVO vo);
}