<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<form:form commandName="vo">
<form:errors element="div" />
<label for="uid">아이디</label>: 
<input type="text" name="uid" id="uid" value="${vo.uid}">
<form:errors path="uid"/> <br>

<label for="upw">암호</label>: 
<input type="password" name="upw" id="upw">
<form:errors path="upw"/> <br>
<br/>

<input type="submit" value="로그인">

</form:form>

<%@ include file="../include/footer.jsp" %>
</body>
</html>