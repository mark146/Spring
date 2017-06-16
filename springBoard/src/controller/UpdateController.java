package controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.*;
import vo.*;

public class UpdateController extends AbstractController {
	private BoardVO vo;
	private BoardService bs;

	public void setBoardVO(BoardVO vo) {
		this.vo = vo;
	}

	public void setboardService(BoardService bs) {
		this.bs = bs;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
		vo.setPageNum(request.getParameter("pageNum"));
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setWriter(request.getParameter("writer"));
		vo.setSubject(request.getParameter("subject"));
		vo.setEmail(request.getParameter("email"));
		vo.setContent(request.getParameter("content"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setReg_date(new Timestamp(System.currentTimeMillis()) );
		vo.setIp(request.getRemoteAddr());

		bs.updateArticle(vo);
		
		request.setAttribute("vo", vo);
		if (vo.getCheck() == 0 ) {
			return new ModelAndView("ajax","Result",vo.getCheck());	
		} else {
			return new ModelAndView("ajax","Result",vo.getCheck());					
		}
	}
}