<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="include/header.jsp" %>

<c:if test="${! empty login}">
<h3>${login.uid}님 어서오세요</h3>
<a href="user/logout">로그아웃</a>
</c:if>
<c:if test="${empty login}">
<a href="user/login">로그인</a>
</c:if>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%@ include file="include/footer.jsp" %>
</body>
</html>