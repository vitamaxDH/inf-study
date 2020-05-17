<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="../layout/userLayout/userHeader.jsp"%>
<link href="resources/common/css/userCss/wishList.css" rel="stylesheet">
<h3 class="heading">위시리스트</h3>
<div class="control_container">
	<div class="control order_by">
		<label class="label">정렬 기준</label>
		<div class="select">
			<select>
				<option value="published_date">최신순</option>
				<option value="title">제목순</option>
				<option value="student_cnt">학생수순</option>
				<option value="rating">평점순</option>
			</select>
		</div>
	</div>
</div>

<%@include file="../layout/userLayout/userFooter.jsp"%>
<script src="resources/common/js/ckeditor.js"></script>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>