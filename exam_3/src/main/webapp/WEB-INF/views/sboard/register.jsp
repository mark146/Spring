<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<%@ include file="../include/header.jsp" %>
<body>

 <form role="form" method="post">
  <div class="box-body">
   <div class="form-group">
    <label for="exampleInputEmail1">Title</label>
    <input type="text" name="title" class="form-control" placeholder="Enter Title">
   </div>
   
   <div class="form-group">
    <label for="exampleInputPassword1">Content</label>
    <textarea class="form-control" name="content" rows="3" placeholder="Enter.."></textarea>
   </div>
   
   <div class="form-group">
    <label for="exampleInputEmail">Writer</label>
    <input type="text" name="writer" class="form-control" placeholder="Enter Writer">
   </div>
  </div>
  
  <div class="box-footer">
   <button type="submit" class="btn btn-primary">Submit</button>
  </div>
 </form>
 
<%@ include file="../include/footer.jsp" %>
</body>
</html>