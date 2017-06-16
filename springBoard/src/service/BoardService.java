package service;
 
import vo.*;
 
public class BoardService {
    private IBoardService ibs;

    public void setiBoardService(IBoardService ibs) {
    	this.ibs = ibs;
    }
    
    public void articleList(BoardVO vo) {
    	ibs.articleList(vo);
    }
    
    public void write(BoardVO vo) {
    	ibs.write(vo);
    }
    
    public void content(BoardVO vo) {
    	ibs.content(vo);
    }
    
	public void updateGetArticle(BoardVO vo) {
		ibs.updateGetArticle(vo);
	}
	
	public void updateArticle(BoardVO vo) {
		ibs.updateArticle(vo);
	}
	
	public void delete(BoardVO vo) {
		ibs.delete(vo);
	}
 }