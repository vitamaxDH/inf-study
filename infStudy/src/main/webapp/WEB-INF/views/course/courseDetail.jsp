<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%> 
<c:set var="root" value="${pageContext.request.contextPath }"/>

<div id="root">
	<main id="main">
		<section class="course_header_container">
			<div class="container">
				<div class="columns">
					<div class="column img_container">
						<img alt="강의 이미지" src="https://i.gifer.com/72wX.gif">	
					</div>
					<div class="column course_title">
						<h1>강의 제목</h1>
						<span>
							<div class="rating_star">별점</div>
							<small>(OO개의 수강평)</small> <br />
						</span>
						<small class="student_cnt">OOO명의 수강생</small> <br />
						<small class="course_skills">카테고리명</small> <br />
					</div>
				</div>
			</div>
		</section>	
		<section class="course_description_container">
			<div class="tabs">
				<ul class="container">
					<li class="curriculum reviews"><a href="#">강의소개</a></li>
					<li class="questions"><a href="#">질문 & 답변</a></li>
				</ul>
			</div>
			
			
		</section>	
	</main>
	
</div>


	
<link href="${root }/resources/common/css/courseCss/courseDetail.css" rel="stylesheet">	
<script	src="${root }/resources/common/js/ckeditor.js"></script>
<%-- 
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
 --%>