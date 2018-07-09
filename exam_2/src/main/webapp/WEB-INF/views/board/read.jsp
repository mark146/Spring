<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<%@ include file="../include/header.jsp" %>
<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/modify");
		formObj.attr("method", "get");
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/remove");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		self.location = "/board/listAll";
	});
	
});
</script>
<body>



<form role="form" method="post">
 <input type="hidden" name="bno" value="${boardVO.bno}">
</form>
 
 <div class="box-body">
  <div class="form-group">
   <label for="exampleInputEmail1">Title</label>
   <input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly">
  </div>
 </div>
 
<div class="box-footer">
 <button type="submit" class="btn btn-warning">Modify</button>
 <button type="submit" class="btn btn-danger">Remove</button>
 <button type="submit" class="btn btn-primary">List All</button>
</div>
 
<%@ include file="../include/footer.jsp" %>
</body>
</html>