<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>ReviewReply</h1>
    <form:form modelAttribute="reviewReplyVO" id="myForm">
        <form:hidden path="r_no" value="${r_no}"/>
        <form:hidden path="u_no" value="${login.u_no}"/>
		<form:textarea path="content" rows="10" resize="none" id="content" placeholder="수강평은 300자 내로 입력이 가능합니다."/> 
		<div id="stringCnt"></div>
		<button id="submitBtn">수강평 남기기</button>
    </form:form>
</body>

<script>

document.getElementById('submitBtn').addEventListener('click', function(e){

	e.preventDefault();
	var content = document.getElementById('content').value;
	var status = true;
	
	if(content.trim().length == 0){
		alert('수강평을 남겨주세요')
		status = false;
		return false;
	}

	if(content.length > 300){
		alert("수강평은 300자까지 입력이 가능합니다.")
		status = false;
		return false;
	}


	var myForm = document.getElementById('myForm');
	myForm.setAttribute('action', "${root}/review/enrollReviewReply");
	myForm.setAttribute('method', 'post');
	myForm.submit();

	opener.window.location.href = "${root}/course/${lecture_title}"
	self.close();

})

document.getElementById('content').addEventListener('keyup', function(){

	var content = document.getElementById('content').value;
	var stringCnt = document.getElementById('stringCnt');

	if(content.length <= 300){
		stringCnt.innerHTML = '<p>(' + content.length + '자/300자)</p>'
	}else{
		stringCnt.innerHTML = '<p style="color:red;">글자수가 초과했습니다.(' + content.length + '자/300자)</p>'
	}
})

</script>

</html>