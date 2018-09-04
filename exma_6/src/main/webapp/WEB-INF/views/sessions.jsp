<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <head>
        <title>Customer Support</title>
    </head>
    
    <body>
        <h2>Sessions</h2>
	There are a total of ${numberOfSessions} active sessions in this application.
	<br /><br />
    
    <c:forEach items="${sessionList}" var="s">
        <c:out value="${s.id} - ${s.getAttribute('username')}" />
        <c:if test="${s.id == pageContext.session.id}">&nbsp;(you)</c:if>
	<br />
    </c:forEach>	
    
    <a href="<c:url value='/'/>">[홈으로 가기]</a>
    
    </body>
</html>