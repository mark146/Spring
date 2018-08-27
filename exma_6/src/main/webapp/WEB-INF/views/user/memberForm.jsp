<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
</head>
<body>

<form:form method="post" commandName="vo">
    <label for="uid">아이디</label>:
    <form:input path="uid"/> 
    <form:errors path="uid"/> <br/>
    
    <label for="upw">암호</label>:
    <form:password path="upw"/> 
    <form:errors path="upw"/> <br/>
    
    <label for="confirm">암호 확인</label>:
    <form:password path="confirm"/> 
    <form:errors path="confirm"/> <br/>
    
    <input type="submit" value="가입" />
</form:form>
</body>
</html>