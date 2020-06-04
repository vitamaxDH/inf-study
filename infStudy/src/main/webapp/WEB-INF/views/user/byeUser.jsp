<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
   src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
<link href="resources/common/css/review.css" rel="stylesheet">
<link href="resources/common/css/userCss/profile.css" rel="stylesheet">
</head>
<body>

<h1>탈퇴하기</h1>
<form:form method="post" action="byeUser" modelAttribute="byeUserVO">
   <div class = "form-group">
      <form:label path="email">이메일</form:label>
      <form:input path="email" class="form-control" id="email" placeholder="이메일"/>
   </div>
   <div class="form-group">
      <form:label path="password">비밀번호</form:label>
      <form:input path="password" type="password" class="form-control" id="password" placeholder="비밀번호"/>
   </div>
   <form:button name="byeBtn" id="byeBtn" class="btn btn-default submitBtn">탈퇴하기</form:button>
</form:form>


</body>
</html>