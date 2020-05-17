<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="../layout/userLayout/userHeader.jsp"%>
<link href="resources/common/css/userCss/my-questions.css" rel="stylesheet">
<div class="header-question">
	<h3 class="heading">내 질문</h3>
	<div class="container">
      <select class="form-control" style="width: 130px;padding-left: 0px;">
        <option value="0">모든 질문</option>
        <option value="1">미답변 질문</option>
        <option value="2">답변 완료 질문</option>
      </select>
    </div>
</div>
<hr />
<div class="question-list">
	<div class="question">
		<span>Q.</span><br/>
	</div>
</div>



<%@include file="../layout/userLayout/userFooter.jsp"%>
<script src="resources/common/js/ckeditor.js"></script>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>