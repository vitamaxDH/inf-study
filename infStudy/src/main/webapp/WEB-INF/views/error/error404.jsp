<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>404 error</title>
</head>
<body>
	<h3>InfStudy</h3>
	<h1>404 Error</h1>
	<button id="backBtn">이전 페이지로 돌아가기</button>
</body>
</html>
<script>

	document.getElementById('backBtn').addEventListener('click', function(){
		history.back(1);
	})
</script>
<style>
body{
    width: 100%;
    height: 100%;
    background-color: blue;
    color: white;
    text-align: center;
    padding-top: 100px;
    font-size: 50px;
    margin:0
}
h3{
	margin:0;
	background-color:white;
	color:blue;
}
h1{
    margin: 80px 0;    
}
button{
    background-color: white;
    font-size: 40px;
    font-weight: bold;
    padding: 10px 20px;
    border: none;
    outline: none;
    color: blue;
    width: 100%;
}
</style>