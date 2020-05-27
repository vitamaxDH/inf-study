<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath} " />
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

<script>
	$(funcion(){
		$("#joinBtn").click(function(){
			var state = true;
			var msg = "모두 입력하세요."

			if(!$("#email").val()){
				state = false;	
			}
			if(!$("password").val()){
				state = false;
			}
			if(!$("passwordChk").val()){
				state = false;
				msg="비밀번호를 확인하세요"
			}
			if(state){
				$("#myform").attr("action","signupCheck");
				$("#myform").attr("method","post");
				$("#myform").submit();
			} else{
				alert(msg);
			}		
		})
	})
</script>
</head>
<script src="resources/common/js/ckeditor.js"></script>
<body>
	<div class="loginForm">
		<h1>회원가입</h1>
		<form:form method="post" action="signupCheck"
			modelAttribute="regUserVO">
			<div class="form-group">
				<form:label path="email">이메일 주소</form:label>
				<form:input path="email" class="form-control"
					placeholder="이메일" />
				<form:errors path="email" style="color:red" />
			</div>
			<div class="form-group">
				<form:label path="password">비밀번호</form:label>
				<form:password path="password" class="form-control"
					placeholder="비밀번호" />
				<form:errors path="password" style="color:red" />

			</div>
			<div class="form-group">
				<label path="passwordChk">비밀번호 확인</label> <input type="password"
					class="form-control" id="passwordchk" placeholder="비밀번호">
				<form:errors path="passwordChk" style="color:red" />
			</div>
			<div class="form-group">
				<form:label path="nickname">닉네임</form:label>
				<form:input type="text" path="nickname" class="form-control" placeholder="닉네임" />
			</div>
			<form:button type="submit" class="btn btn-default submitBtn">가입하기</form:button>
		</form:form>
	</div>
</body>
</html>