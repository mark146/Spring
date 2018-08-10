<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<%@ include file="../include/header.jsp" %>
<body>
<form action="/user/loginPost" method="post">
 <div class="form-group has-feedback">
  <input type="text" name="uid" class="form-control" placeholder="USER ID" />
  <span class="glyphicon glyphicon-lock form-control-feedback"></span>
 </div>
 
 <div class="form-group has-feedback">
  <input type="password" name="upw" class="form-control" placeholder="Password" />
  <span class="glyphicon glyphicon-lock form-control-feedback"></span>
 </div>
 
 <div class="row">
  <div class="col-xs-8">
   <div class="checkbox icheck">
    <label>
     <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
    </label>
   </div>
  </div>
 </div>
</form>
<%@ include file="../include/footer.jsp" %>
</body>
</html>