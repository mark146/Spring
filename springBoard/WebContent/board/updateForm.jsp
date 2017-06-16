<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<title>게시판</title>
<link href="<%=contextPath%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
		BoardVO vo = (BoardVO) request.getAttribute("vo");
%>
<body>
	<div class="container">
		<div class="jumbotron">
		<div class="col-sm-3"></div>
			<div class="row">
			<div class="col-sm-6">
			
				<h2>글수정</h2> 
				<br>

				<form class="updateForm" action="<%=contextPath%>/jdbc/update">
					<input type="hidden" name="pageNum" value="<%=pageNum%>">
					<input type="hidden" name="num" value="<%=vo.getNum()%>">

					<table  class="table table-bordered table-hover" width="400">
						<tr>
							<td width="70" align="center" class="success">이 름</td>
							<td align="left" width="330">
							<input type="text" class="form-control" maxlength="10" name="writer" value="<%=vo.getWriter()%>">
						</tr>
						
						<tr>
							<td width="70" align="center" class="success">제 목</td>
							<td align="left" width="330">
							<input type="text" class="form-control" maxlength="50" name="subject" value="<%=vo.getSubject()%>"></td>
						</tr>
						
						<tr>
							<td width="70" align="center" class="success">Email</td>
							<td align="left" width="330">
							<input type="text" class="form-control" maxlength="30" name="email" value="<%=vo.getEmail()%>"></td>
						</tr>
						<tr>
							<td width="70" align="center" class="success">내 용</td>
							<td align="left" width="330">
							<textarea name="content" class="form-control" 	rows="13" cols="40"><%=vo.getContent()%></textarea></td>
						</tr>
						
						<tr>
							<td width="70" align="center" class="success">비밀번호</td>
							<td align="left" width="330"><input type="password" class="form-control"  maxlength="12" name="passwd"></td>
						</tr>
						
						<tr>
							<td colspan=2 align="center">
							<input type="button" value="글수정" id="update"> 
							<input type="reset" value="다시작성">
							<a href="<%=contextPath%>/jdbc/board">목록보기</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=contextPath %>/js/board.js"></script>
</body>
</html>
