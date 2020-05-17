<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="../layout/userLayout/userHeader.jsp"%>
<link href="resources/common/css/userCss/my-courses.css" rel="stylesheet">
<h3 class="heading">내 강의</h3>
<div class="row">
	<div class="control_container">
		<div class="control order_by">
			<label class="label is-hidden-mobile">정렬 기준</label>
			<div class="select">
				<select>
					<option value="recent">최근 공부한 순</option>
					<option value="abc">제목순</option>
				</select>
			</div>
		</div>
		<div class="control filter_progress">
			<label class="label is-hidden-mobile">진행률</label>
			<div class="select">
				<select>
					<option value="now_learning">학습중</option>
					<option value="finished">완강</option>
					<option value="all">모두보기</option>
				</select>
			</div>
		</div>

		<div class="field has-addons">
			<div class="control">
				<input class="input e_search_input" type="text" placeholder="검색어 입력">
			</div>
			<div class="control">
				<a class="button is-info e_search_btn">검색</a>
			</div>
		</div>
	</div>
	<div class="course-list"></div>
</div>
<%@include file="../layout/userLayout/userFooter.jsp"%>
<script src="resources/common/js/ckeditor.js"></script>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>