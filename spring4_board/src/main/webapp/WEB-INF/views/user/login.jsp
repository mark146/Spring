<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<%@ include file="../include/header.jsp" %>
<body>

<form:form commandName="vo">
<form:errors element="div" />
<label for="email">이메일</label>: 
<input type="text" name="email" id="email" value="${vo.email}">
<form:errors path="email"/> <br>

<label for="password">암호</label>: 
<input type="password" name="password" id="password">
<form:errors path="password"/> <br>
<br/>

<input type="submit" value="로그인">

</form:form>

<%@ include file="../include/footer.jsp" %>
</body>
</html>