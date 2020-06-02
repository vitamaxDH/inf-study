<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<body>
	<h1>질문 남기기</h1>
	<form:form id="myForm" modelAttribute="qnaVO">
		<form:hidden path="l_no"/>
		<form:hidden path="u_no" value="${login.u_no }"/>
		<form:label path="title">제목</form:label> <br />
		<form:input path="title" maxlength="32" id="title"/> <br />
		<div id="titleMsg"></div>
		<form:label path="content">질문</form:label>
		<form:textarea path="content" rows="10" resize="none" id="content" placeholder="질문은 1000자 내로 입력이 가능합니다."/> 
		<div id="stringCnt"></div>
		<button id="submitBtn">질문 남기기</button>
	</form:form>

<script>


document.getElementById('submitBtn').addEventListener('click', function(e){

	e.preventDefault();
	var title = document.getElementById('title').value;
	var content = document.getElementById('content').value;
	var status = true;
	
	if(title.trim().length == 0){
		alert('제목을 적어주세요')
		status = false;
		return false;
	}

	if(title.length > 30){
		alert("제목은 30자까지 입력이 가능합니다.")
		status = false;
		return false;
	}

	if(content.trim().length == 0){
		alert('질문을 남겨주세요')
		status = false;
		return false;
	}

	if(content.length > 1000){
		alert("질문은 1000자까지 입력이 가능합니다.")
		status = false;
		return false;
	}


	var myForm = document.getElementById('myForm');
	myForm.setAttribute('action', "${root}/qna/enrollQna");
	myForm.setAttribute('method', 'post');
	myForm.submit();

	opener.window.location.href = "${root}/course/${lecture_title}/questions"
	self.close();

})

document.getElementById('title').addEventListener('keyup', function(){

	var title = document.getElementById('title').value;
	var titleMsg = document.getElementById('titleMsg');

	if(title.length <= 30){
		titleMsg.innerHTML = '<p>(' + title.length + '자/30자)</p>';
	}else{
		titleMsg.innerHTML = '<p style="color:red;">글자수가 초과했습니다.(' + title.length + '자/30자)</p>'
	}

})


document.getElementById('content').addEventListener('keyup', function(){

	var content = document.getElementById('content').value;
	var stringCnt = document.getElementById('stringCnt');

	if(content.length <= 1000){
		stringCnt.innerHTML = '<p>(' + content.length + '자/1000자)</p>'
	}else{
		stringCnt.innerHTML = '<p style="color:red;">글자수가 초과했습니다.(' + content.length + '자/1000자)</p>'
	}
})

</script>


</body>
</html>