<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>인덱스 페이지</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="name"/>님 환영합니다.
</sec:authorize>
<ul>
	<li><a href="<c:url value='/homeMain' />">/home/main</a></li>
	<li><a href="<c:url value='/memberMain' />">/member/main</a></li>
	<li><a href="<c:url value='/managerMain' />">/manager/main</a></li>
	<li><a href="<c:url value='/adminMain' />">/admin/main</a></li>
	<sec:authorize access="isAuthenticated()">
	 <form:form action="/controller/logout" method="POST">
        <input type="submit" value="로그아웃" />
    </form:form>
	</sec:authorize>
</ul>
</body>
</html>
