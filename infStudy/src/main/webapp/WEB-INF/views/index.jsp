<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>

</head>
<body>
	<h1>위지윅 에디터 적용하는건 안어려운데!</h1>
	<br />
	<h1>db에 넣는거 공부 중</h1>
	<form:form role="form" method="POST" modelAttribute="testCkVO"
		action="${pageContext.request.contextPath}/testSave">
		<form:input path="title"/>
		<form:textarea path="content" id="content"/>
		<input type="submit" value="실험!">
		<button id="saveBtn">알림창 띄우기 버튼</button>
	</form:form>
	<script
		src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>
	<script>
		const saveBtn = document.getElementById('saveBtn');
		saveBtn.addEventListener('click', function(e) {
			e.preventDefault();
			alert('클릭됨');
		});
		window.onload = CKEDITOR.replace("content", {

		//filebrowserUploadUrl :"/imageUpload.do"
		// filebrowserImageUploadUrl: 'MacaronicsServlet?command=ckeditor_upload'	
		});
	</script>
</body>
</html>
