<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>404 error</title>
   <link href="/resources/common/css/error.css" rel="stylesheet">
</head>
<style>

body{
    width: 100%;
    height: 100%;
    background-color: rgb(0,196,113);
    color: white;
    text-align: center;
    padding-top: 100px;
    font-size: 50px;
    margin:0
}
h3{
	margin:0;
	background-color:white;
	color:rgb(0,196,113);
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
    color: rgb(0,196,113);
    width: 100%;
    transition: 1s;
}
button:hover{
	transition: 1s;
	background-color: rgba(0,196,113, 0.5);
	color: white;
	cursor:pointer;
}
</style>
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