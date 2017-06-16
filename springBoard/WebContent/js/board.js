$(document).ready(function(){	

	$("#delete").click(function(){
		var pwd = $(".passwd").val();

		if (pwd=="") {
			alert("비밀번호를 입력하세요");
		} else {
			$.ajax({
				url : '/springBoard/jdbc/delete',
				type : 'Post',
				async: false,
				dataType : "text",
				data : $(".deleteForm").serialize(),
				success : function(data) {
					if (data > 0) {
						alert("성공");
						location.replace('/springBoard/jdbc/board');			
					} else {
						alert("비밀번호가 틀렸습니다.");
					}
				}
			})
		}
	});	

	$("#write").click(function(){
		if ($('.pwd').val() == "") {
			alert("비밀번호를 입력하세요");
			return false;
		}
	});

	$("#update").click(function(){
		var form = $(".updateForm").serialize();

		$.ajax({
			url : '/springBoard/jdbc/update',
			type : 'Post',
			async: false,
			dataType : "text",
			data : form,
			success : function(data) {
				if ($.trim(data) > 0) {
					alert("성공");
					location.replace('/springBoard/jdbc/board');
				} else {
					alert("비밀번호가 틀렸습니다.");
				}
			}
		})
	});

});