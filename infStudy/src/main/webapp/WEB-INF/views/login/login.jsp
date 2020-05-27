<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>footer</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/signUp.css" rel="stylesheet">
<script src="resources/common/js/ckeditor.js"></script>

</head>
<body>
	<div class="loginForm">
		<div class="card-body">
			<c:if test="${fail==true}">
				<div class="alert alert-danger">
					<h3>로그인 실패</h3>
					<p>이메일과 비밀번호를 확인해주세요</p>
				</div>
			</c:if>
		</div>
		<h1>로그인</h1>
		<form:form method="post" action="loginCheck"
			modelAttribute="loginUserVO">
			<div class="form-group">
				<form:label path="email">이메일 주소</form:label>
				<form:input path="email" class="form-control"
					placeholder="이메일을 입력해주세요" />
				<form:errors path="email" class="form-err" style="color:red" />
			</div>
			<div class="form-group">
				<form:label path="password">비밀번호</form:label>
				<form:password path="password" class="form-control"
					placeholder="비밀번호를 입력하세요" onkeyup="chkpw()" />
				<p style="color: red">${pwErrorMsg}</p>
			</div>
			<div class="form-group">
				<form:button name="joinBtn" id="joinBtn"
					class="btn btn-default submitBtn">로그인</form:button>
			</div>
			<div id="naver_id_login" style="text-align: center">
				<a href="${url}"><img width="187" src="${contextPath}/resources/common/images/naarolo.PNG" /></a>
			</div>
			<div id="google_id_login" style="text-align: center">
				<a href="${google_url}"><img src="${contextPath}/resources/common/images/google_button.png"/></a>
			</div>
		</form:form>
	</div>
</body>
</html>



<!-- <script>
	function chkpw() {
		var pw = document.querySelector("#password").value;
		var chkMsg = document.querySelector("#pwErrorChkMsg");
		console.log(pw);
		if (pw.length < 8) {
			chkMsg.innerHTML = "8자리에서 20자리를 입력해주세요.";
		} else {
			chkMsg.innerHTML = "통과^^";
		}
	}
</script> -->