<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="<%=contextPath %>/exam1">예제1</a><br>
<a href="<%=contextPath %>/exam2">예제2</a><br>
<a href="<%=contextPath %>/doJSON">예제3</a>

</body>
</html>
