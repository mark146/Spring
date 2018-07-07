<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<script>
 var result = '${msg}';
 
 if(result=='SUCCESS') {
	 alert("처리가 완료되었습니다.");
 }

</script>
<body>
<%@ include file="../include/header.jsp" %>

<table class="table table-bordered">
 <tr>
	<th style="width: 10px">BNO</th>
	<th>TITLE</th>
	<th>WRITER</th>
	<th>REGDATE</th>
	<th style="width: 40px">VIEWCNT</th>
 </tr>
</table>
 
<%@ include file="../include/footer.jsp" %>
</body>
</html>