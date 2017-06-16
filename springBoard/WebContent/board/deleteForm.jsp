<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.*"%>
<%
	String contextPath = request.getContextPath();
%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
%>
<html>
<head>
<title>게시판</title>
<link href="<%=contextPath%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
				<b>글삭제</b> <br>
				
				<form class="deleteForm" action="#">
					<table border="1">
						<tr height="30">
							<td align=center><b>비밀번호를 입력해 주세요.</b></td>
						</tr>
						<input type="hidden" name="pageNum" value="<%=pageNum%>">
						
						<tr height="30">
							<td align=center>비밀번호 : 
							<input type="password" class="passwd" name="passwd"size="8" maxlength="12"> 
							<input type="hidden" name="num" value="<%=num%>"></td>
						</tr>
						
						<tr height="30">
							<td align=center>
							<input type="button" value="글삭제" id="delete">						
							<a href="<%=contextPath%>/jdbc/board">글목록</a>
							</td>
						</tr>
					</table>
				</form>
				
				</div>
				<div class="col-sm-4"></div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=contextPath %>/js/board.js"></script>
</body>
</html>