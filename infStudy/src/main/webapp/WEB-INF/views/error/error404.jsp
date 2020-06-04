<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>404 Error</h1>
	
		<button id="backBtn">이전페이지로 돌아가기</button>

<script>

	document.getElementById('backBtn').addEventListener('click', function(){
		history.back(1);
	})
</script>

</body>
</html>