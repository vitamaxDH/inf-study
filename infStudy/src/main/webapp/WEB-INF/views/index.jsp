<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%> 


	<h1>위지윅 에디터 적용하는건 안어려운데!</h1>
	<br />
	<h1>db에 넣는거 공부 중</h1>
	<form:form role="form" method="POST" modelAttribute="testCkVO"
		action="${contextPath}/testSave">
		<form:input path="title"/>
		<form:textarea path="content" id="content"/>
		<input type="submit" value="실험!">
		<button id="saveBtn">알림창 띄우기 버튼</button>
	</form:form>
	
	
	<script	src="resources/common/js/ckeditor.js"></script>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>