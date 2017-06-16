package entity;

import vo.*;

public interface IBoardEntity {
	public void getArticleCount(BoardVO vo);
	public void getArticles(BoardVO vo);
	public void insertArticle(BoardVO vo);
	public void getArticle(BoardVO vo);
	public void updateGetArticle(BoardVO vo);
	public void updateArticle(BoardVO vo);
	public void deleteArticle(BoardVO vo);
}