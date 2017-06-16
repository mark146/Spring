package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.*;
import vo.*;

public class BoardController extends AbstractController {
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
		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}

		vo.setPageSize(10);
		vo.setCurrentPage(Integer.parseInt(pageNum));
		vo.setStartRow((vo.getCurrentPage() - 1) * vo.getPageSize() + 1);
		vo.setEndRow(vo.getCurrentPage() * vo.getPageSize());

		bs.articleList(vo);

		vo.setNumber(vo.getCount() - (vo.getCurrentPage()-1) * vo.getPageSize());
		request.setAttribute("vo", vo);
		request.setAttribute("pageNum",pageNum );
		return new ModelAndView();
	}
}