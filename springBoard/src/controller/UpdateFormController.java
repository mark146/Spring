package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.*;
import vo.*;

public class UpdateFormController extends AbstractController {
	private BoardVO vo;
	private BoardService bs;

	public void setboardService(BoardService bs) {
		this.bs = bs;
	}
	
	public void setBoardVO(BoardVO vo) {
		this.vo = vo;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
		vo.setNum(Integer.parseInt((String)request.getParameter("num")));
		
		bs.updateGetArticle(vo);
		
		request.setAttribute("vo", vo);
		return new ModelAndView();
	}
}