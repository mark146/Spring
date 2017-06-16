<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<%@ page import="vo.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%!SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
<%
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}

	BoardVO vo = (BoardVO) request.getAttribute("vo");
	int count = vo.getCount();
	int number = vo.getNumber();
	pageNum = vo.getPageNum();
	int pageSize = vo.getPageSize();
	List<BoardVO> list = vo.getList();
%>

<html lang="en">
<head>
<title>게시판</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-sm-12">

					<table class="table">
						<tr>
							<td>
								<h2>
									글목록(전체 글:<%=count%>)
								</h2>
							</td>
						</tr>
					</table>

					<table class="table">
						<tr align="right">
							<td>
								<h4>
									<a href="<%=contextPath%>/board/writeForm.jsp">글쓰기</a>
								</h4>
							</td>
					</table>

					<%
						if (count == 0) {
					%>

					<table>
						<tr>
							<td align="center">게시판에 저장된 글이 없습니다.</td>
						</tr>
					</table>

					<%
						} else {
					%>

					<table class="table table-bordered table-hover">
						<tr height="30" class="warning">
							<td align="center" width="50">번 호</td>
							<td align="center" width="250">제 목</td>
							<td align="center" width="100">작성자</td>
							<td align="center" width="150">작성일</td>
							<td align="center" width="50">조 회</td>
							<td align="center" width="100">IP</td>
						</tr>

						<%
							for (int i = 0; i < list.size(); i++) {
									BoardVO article = (BoardVO) list.get(i);
						%>
						<tr height="30" class="success" align="center">
							<td width="50"><%=number--%></td>

							<td width="250">
								<%
									int wid = 0;
											if (article.getRe_level() > 0) {
												wid = 5 * (article.getRe_level());
								%> <img src="<%=contextPath%>/img/level.gif" width="<%=wid%>"
								height="16"> <img src="<%=contextPath%>/img/re.gif">
								<%
									} else {
								%> <img src="<%=contextPath%>/img/level.gif" width="<%=wid%>"
								height="16"> <%
 	}
 %> <a
								href="<%=contextPath%>/jdbc/content?num=<%=article.getNum()%>&pageNum=<%=vo.getCurrentPage()%>&cmd=content">
									<%=article.getSubject()%></a> <%
 	if (article.getReadcount() >= 20) {
 %> <img src="<%=contextPath%>/img/hot.gif" border="0" height="16">
								<%
									}
								%>
							</td>

							<td width="100"><a href="mailto:<%=article.getEmail()%>"><%=article.getWriter()%></a></td>
							<td width="150"><%=sdf.format(article.getReg_date())%></td>
							<td width="50"><%=article.getReadcount()%></td>
							<td width="100"><%=article.getIp()%></td>
						</tr>
						<%
							}
						%>
					</table>
					<%
						}
					%>

					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-6">
							<ul class="pagination pagination-sm pagination-center">
								<%
									if (count > 0) {
										int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
										int startPage = (int) (vo.getCurrentPage() / 10) * 10 + 1;
										int pageBlock = 10;
										int endPage = startPage + pageBlock - 1;
										if (endPage > pageCount)
											endPage = pageCount;

										if (startPage > 10) {
								%>
								<li><a
									href="<%=contextPath%>/jdbc/board?pageNum=<%=startPage - 10%>">[이전]</a></li>
								<%
									}
										for (int i = startPage; i <= endPage; i++) {
								%>
								<li><a href="<%=contextPath%>/jdbc/board?pageNum=<%=i%>"><%=i%></a></li>
								<%
									}
										if (endPage < pageCount) {
								%>
								<li><a
									href="<%=contextPath%>/jdbc/board?pageNum=<%=startPage + 10%>">[다음]</a></li>
								<%
									}
									}
								%>
							</ul>
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr>
	<div class="footer p-t-1 text-center">
		<div class="container">
			<strong>서울특별시 금천구 가산동 000 번지 요안도라</strong>
			<address>tkdt##@naver.com</address>
			<p>Copyright ⓒ. All rights reserved.</p>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=contextPath%>/js/board.js"></script>
</body>
</html>

