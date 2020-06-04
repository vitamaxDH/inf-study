<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>405 error</title>
   <link href="/resources/common/css/error.css" rel="stylesheet">
</head>
<body>
	<h3>InfStudy</h3>
	<h1>405 Error</h1>
	<button id="backBtn">이전 페이지로 돌아가기</button>
<script>

	document.getElementById('backBtn').addEventListener('click', function(){
		history.back(1);
	})
</script>
	
</body>
</html>