<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ErrorPage</title>
</head>
<body>
요청 작업 처리 중 에러가 발생 했습니다. <br>
잠시 후 다시 시도해주세요.
 <h4>${exception.getMessage()}</h4>
</body>
</html>