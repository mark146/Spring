<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
iframe {
	width: 0px;
	height: 0px;
	border: 0px;
}
</style>

<title>Insert title here</title>
</head>
<body>
<script>

var result = "${savedName}";

parent.addFilePath(result);
</script>

	<form id='form1' action="uploadForm" method="post"
		enctype="multipart/form-data" target="zeroFrame">
		<input type="file" name="file"><input type="submit">
	</form>
	
	<iframe name="zeroFrame"></iframe>
	
<script>
function addFilePath(msg) {
	alert(msg);
	document.getElementById("form1").reset();
}

</script>
</body>
</html>