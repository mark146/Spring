<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<style>
.fileDrop {
 width: 80%;
 height: 100px;
 border: 1px dotted gray;
 background-color: lightslategrey;
 margin: auto;
}
</style>
</head>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template" type="text/x-handlebars-template">
<li>
 <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
 <div class="mailbox-attachment-info">
 <a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
 <a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
 </div>
</li>
</script>

<script>
$(document).ready(function() {
var template = Handlebars.compile($("#template").html());

$(".fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
});

$(".fileDrop").on("drop", function(event){
	event.preventDefault();
	
	//드래그된 파일의 정보
	var files = event.originalEvent.dataTransfer.files;
	var file = files[0];
	
	//ajax로 전달할 폼 객체
	var formData = new FormData();
	//폼 객체에 파일추가, append("변수명", 값)
	formData.append("file", file);
	
	$.ajax({
		url: "/uploadAjax",
		data: formData,
		dataType: "text",
		processData: false,// true = GET방식, false => POST방식
		contentType: false,/* true = application/x-www-form-urlencoded, false = multipart/form-data */ 
		type: "POST",
		success: function(data) {
			var fileInfo = getFileInfo(data);
			var html = template(fileInfo);
			
			$(".uploadedList").append(html);
		}
	});
});

$("#registerForm").submit(function(event){
	event.preventDefault();
	var that = $(this);
	var str ="";
	
	$(".uploadedList .delbtn").each(function(index){
		str += "<input type='hidden' name='files["+index+"]' value='"+$(this).attr("href") +"'> ";
	});
		
	that.append(str);
	that.get(0).submit();
});
});
</script>
<body>
 <form id='registerForm' role="form" method="post">
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
   
   <div class="form-group">
    <label for="exampleInputEmail1">File DROP Here</label>
    <div class="fileDrop"></div>
   </div>
  </div>
  
  <div class="box-footer">
   <div><hr></div>
   
   <ul class="mailbox-attachments clearfix uploadedList">
   </ul>
   
   <button type="submit" class="btn btn-primary">Submit</button>
  </div>
 </form>
 
<%@ include file="../include/footer.jsp" %>
</body>
</html>