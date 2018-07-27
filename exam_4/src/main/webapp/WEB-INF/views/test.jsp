<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<style>
#modDiv {
 width:300px;
 height:100px;
 background-color: gray;
 position: absolute;
 top: 50%;
 left: 50%;
 margin-top: -50px;
 margin-left: -150px;
 padding: 10px;
 z-index: 1000;
}
</style>
<script>
$(document).ready(function() {

	var bno = 1;
	
	function getAllList() {
		
	$.getJSON("/replies/all/"+ bno, function(data) {
		var str = "";
		console.log(data.length);
		
		$(data).each(
				function() {
					str += "<li data-rno='"+this.rno+"' class='replyLi'>"
					+ this.rno + " : " + this.replytext
					+"<button>MOD</button></li>";
				});
		
		$("#replies").html(str);
	});
	
	}

	$("#replyAddBtn").on("click", function(){
		var replyer = $("#newReplyWriter").val();
		var replytext = $("#newReplyText").val();
		
		$.ajax({
			type: 'post',
			url: "/replies",
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"},
			dataType: "text",
			data: JSON.stringify({
				bno: bno,
				replyer: replyer,
				replytext: replytext
			}),
			success: function(result) {
				if (result == "SUCCESS") {
					alert("등록 되었습니다.");
					getAllList();
				}
			}
		})
	});
	
	$("#replyDelBtn").on("click", function(){
		var rno = $(".modal-title").html();
		var replytext = $("#replyText").val();
		
		$.ajax({
			type: 'delete',
			url: "/replies/" + rno,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"},
			dataType: "text",
			success: function(result) {
				console.log("result: " + result);
				if (result == "SUCCESS") {
					alert("삭제 되었습니다.");
					$("#modDiv").hide("slow");
					getAllList();
				}
			}
		})
	});
	
	$("#replyModBtn").on("click", function(){
		var rno = $(".modal-title").html();
		var replytext = $("#replyText").val();
		
		$.ajax({
			type: 'put',
			url: "/replies/" + rno,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"},
			dataType: "text",
			data: JSON.stringify({replytext: replytext}),
			success: function(result) {
				console.log("result : "+ result);
				if (result == "SUCCESS") {
					alert("수정 되었습니다.");
					//getAllList();
					getPageList(replyPage);
				}
			}})
	});
	
	function getPageList(page) {
		$.getJSON("/replies/"+bno+"/"+page, function(data){
			console.log(data.list.length);
			var str="";
			
			$(data.list).each(function(){
			 str += "<li data-rno='"+ this.rno + "' class='replyLi'>"
			 + this.rno + " : " + this.replytext +
			 "<button>MOD</button></li>";
			});
			$("#replies").html(str);
			printPaging(data.pageMaker);
		});
	}
	
	function printPaging(pageMaker) {
		var str="";
		
		if (pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
		}
		
		for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i?'class=active':'';
			str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
		}
		
		if (pageMaker.next) {
			str += "<li><a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
		}
		
		$(".pagination").html(str);
	}
	
	var replyPage = 1;
	
	$(".pagination").on("click", "li a", function(event) {
		event.preventDefault();
		replyPage = $(this).attr("href");
		getPageList(replyPage);
	});
	
	
	$("#replies").on("click", ".replyLi button", function() {
		var reply = $(this).parent();
		var rno = reply.attr("data-rno");
		var replytext = reply.text();
		
		$(".modal-title").html(rno);
		$("#replyText").val(replytext);
		$("#modDiv").show("slow");
	});
});
</script>
<body>

	<h2>Ajax Test Page</h2>
	
	<div>
	 <div>
	  REPLYER <input type="text" name="replyer" id="newReplyWriter">
	 </div>
	 <div>
	  REPLY TEXT <input type="text" name="replytext" id="newReplyText">
	 </div>
	 <button id="replyAddBtn">ADD REPLY</button>
	</div>
	<ul id="replies">
	</ul>
	
	<div id="modDiv">
	 <div class="modal-title"></div>
	 <div>
	  <input type="text" id="replyText">
	 </div>
	 <div>
	  <button type="button" id="replyModBtn">Modify</button>
	  <button type="button" id="replyDelBtn">DELETE</button>
	  <button type="button" id="closeBtn">Close</button>
	 </div>
	</div>
	
	<ul class="pagination">
	</ul>
</body>
</html>