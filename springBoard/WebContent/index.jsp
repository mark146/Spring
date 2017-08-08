<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<ul>
		<li><a href="<%=contextPath%>/jdbc/board">JDBC 게시판1</a></li>
	</ul>
</body>
</html>