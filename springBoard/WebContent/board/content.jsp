<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="vo.*"%>
<%@ page import="java.util.List"%>
<%
	String contextPath = request.getContextPath();
%>
<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");

	String pageNum = vo.getPageNum();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	int num = vo.getNum();
	int ref = vo.getRef();
	int re_step = vo.getRe_step();
	int re_level = vo.getRe_level();
%>
<html>
<head>
<title>게시판</title>
<link href="<%=contextPath %>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<div class="row">

				<h2>글내용 보기</h2>
				<br>
				<div class="col-sm-3"></div>
				<table width="700" class="table table-bordered table-hover">

					<tr height="30" align="center">
						<td width="125" class="success">글번호</td>
						<td width="125"><%=vo.getNum()%></td>
						<td width="125" class="success">조회수</td>
						<td width="125"><%=vo.getReadcount()%></td>
					</tr>

					<tr height="30" align="center">
						<td width="125" class="success">작성자</td>
						<td width="125"><%=vo.getWriter()%></td>
						<td width="125" class="success">작성일</td>
						<td width="125"><%=sdf.format(vo.getReg_date())%></td>
					</tr>

					<tr height="30">
						<td align="center" width="125" class="success">글제목</td>
						<td align="center" width="375" align="center" colspan="3"><%=vo.getSubject()%></td>
					</tr>

					<tr>
						<td align="center" width="125" class="success">글내용</td>
						<td align="left" width="375" colspan="3"><pre><%=vo.getContent()%></pre></td>
					</tr>


					<tr height="30">
						<td colspan="4" align="right"><a
							href="<%=contextPath%>/jdbc/updateForm?num=<%=vo.getNum()%>&pageNum=<%=pageNum%>">글수정</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="<%=contextPath%>/jdbc/deleteForm?num=<%=vo.getNum()%>&pageNum=<%=pageNum%>'">글삭제</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="<%=contextPath%>/jdbc/writeForm?&num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>">답글쓰기</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="<%=contextPath%>/jdbc/board">글목록</a></td>
					</tr>
				</table>
				<div class="col-sm-3"></div>

			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=contextPath %>/js/board.js"></script>
</body>
</html>