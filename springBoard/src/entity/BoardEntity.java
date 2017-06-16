package entity;

import vo.*;

public class BoardEntity {
	private IBoardEntity ibe;

	public void setiBoardEntity(IBoardEntity ibe) {		
		this.ibe = ibe;
	}

	public void articleList(BoardVO vo) {
		ibe.getArticleCount(vo);

		if (vo.getCount() > 0) {
			ibe.getArticles(vo);
		}
	}

	public void write(BoardVO vo) {
		ibe.getArticleCount(vo);
		ibe.insertArticle(vo);
	}

	public void content(BoardVO vo) {
		ibe.getArticle(vo);
	}

	public void updateGetArticle(BoardVO vo) {
		ibe.updateGetArticle(vo);
	}

	public void updateArticle(BoardVO vo) {
		ibe.updateArticle(vo);
	}

	public void delete(BoardVO vo) {
		ibe.deleteArticle(vo);
	}
}