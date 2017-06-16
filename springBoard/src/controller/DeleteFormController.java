package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import vo.*;

public class DeleteFormController extends AbstractController {
	private BoardVO vo;

	public void setBoardVO(BoardVO vo) {
		this.vo = vo;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setPasswd(request.getParameter("passwd"));
		
		request.setAttribute("vo", vo);
		return new ModelAndView();
	}
}