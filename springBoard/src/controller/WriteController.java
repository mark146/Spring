package controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.*;
import vo.*;

public class WriteController extends AbstractController {
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
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setRef(Integer.parseInt(request.getParameter("ref")));
		vo.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		vo.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		vo.setWriter(request.getParameter("writer"));
		vo.setSubject(request.getParameter("subject"));
		vo.setEmail(request.getParameter("email"));
		vo.setContent(request.getParameter("content"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setReg_date(new Timestamp(System.currentTimeMillis()) );
		vo.setIp(request.getRemoteAddr());
		
		bs.write(vo);
		
		request.setAttribute("vo", vo);
		return new ModelAndView(getRedirectUrl(request));
	}

	private String getRedirectUrl(HttpServletRequest request) {
		return "redirect:" + request.getServletPath() + "/board";
	}
}