<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<%@ page import="vo.*"%>
<html>
<head>
<title>게시판</title>
<link href="<%=contextPath%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		BoardVO vo = (BoardVO) request.getAttribute("vo");
			int num = 0, ref = 1, re_step = 0, re_level = 0;
				
			if (request.getParameter("num") != null) {
					num = vo.getNum();
					ref = vo.getRef();
					re_step = vo.getRe_step();
					re_level = vo.getRe_level();
				}
	%>
	<div class="container">
		<div class="jumbotron">
			<div class="col-sm-2"></div>
			<div class="row">
				<div class="col-sm-6">

					<h3>글쓰기</h3>
					<br>
						<form action="/springBoard/jdbc/write" class="writeForm" >
						<input type="hidden" name="num" value="<%=num%>"> 
						<input type="hidden" name="ref" value="<%=ref%>"> 
						<input type="hidden" name="re_step" value="<%=re_step%>"> 
						<input type="hidden" name="re_level" value="<%=re_level%>"> 

						<table class="table table-bordered table-hover" width="400" border="1" cellspacing="0" cellpadding="0" align="center">
							<tr>
							</tr>

							<tr>
								<td align="center" width="90" class="success">이 름</td>
								<td width="310"><input type="text"  class="form-control"  maxlength="10" name="writer"></td>
							</tr>

							<tr>
								<td width="70" align="center" class="success">제 목</td>
								<td width="330">
									<%if (request.getParameter("num") == null) {%> 
								<input type="text" class="form-control" maxlength="50" name="subject"></td>
								<%} else {%>
								<input type="text" class="form-control" maxlength="50" name="subject" value="[답변]"></td>
								<%}%>
							</tr>

							<tr>
								<td width="70" align="center" class="success">Email</td>
								<td width="330"><input type="text" class="form-control"  maxlength="30"
									name="email"></td>
							</tr>

							<tr>
								<td width="70" align="center" class="success">내 용</td>
								<td width="330"><textarea class="form-control" name="content" rows="13" cols="40"></textarea></td>
							</tr>

							<tr>
								<td width="70" align="center" class="success">비밀번호</td>
								<td width="330"><input type="password"  class="form-control pwd" size="8" maxlength="12" name="passwd"></td>
							</tr>

							<tr align="center">
								<td colspan=2><input type="submit"  id="write" value="글쓰기">
								<input type="reset" value="다시작성"> 
								<a href="<%=contextPath%>/jdbc/board">목록보기</a>
								</td>
							</tr>
						</table>
					</form>

				</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=contextPath %>/js/board.js"></script>
</body>
</html>