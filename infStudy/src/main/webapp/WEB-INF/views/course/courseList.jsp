<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%> 


<div id="root">
	<main id="main">
		<section id="courses_section" class="section">
			<div class="container">
				<div class="columns">
					<aside class="column is-2 sidebar_left">
						<nav class="accordions category_accordions">
							<div class="accordion">
								<a href="#" class="accordion-header">전체 강의</a>
							</div>
							<div class="accordion-header">
								 
								<c:forEach var="asideList" items="${asideLectureList }">
								<div class="accordion-body">
									<a href="#" class="accordion-content">${asideList }</a>
								</div>
								</c:forEach>
							
								<!-- 
								<div class="accordion-body">
									<a href="#" class="accordion-content">Javascript</a>
								</div>
								<div class="accordion-body">
									<a href="#" class="accordion-content">Java</a>
								</div>
								<div class="accordion-body">
									<a href="#" class="accordion-content">JSP</a>
								</div>
								<div class="accordion-body">
									<a href="#" class="accordion-content">Spring</a>
								</div>
								<div class="accordion-body">
									<a href="#" class="accordion-content">Spring-boot</a>
								</div>
								 -->
							</div>
						</nav>
					</aside>
					<!-- 
					<div class="column courses_body">
						<header class="courses_header">
							<div class="search">
								<input type="text" class="input" placeholder="강의 검색하기" />	
								<button type="button" class="button">검색</button>
							</div>
						</header>
						<main class="courses_main">
							<nav class="breadcrumb">
								<ul>
									<li><a href="#" class="category_link">전체</a></li>
									<li><a href="#" class="category_link">개발 프로그래밍</a></li>
									<li><a href="#" class="category_link">웹 개발</a></li>
								</ul>
								<div class="select coures_order_select"><select name="order_select" id="courses_order_selector">
										<option value="seq" selected>추천순</option>
										<option value="popular">인기순</option>
										<option value="recent">최신순</option>
										<option value="rating">평점순</option>
										<option value="famous">학생수순</option>
									</select>
								</div>
							</nav>
						</main>
					</div>
					 -->
				</div>
			</div>
		</section>
	</main>
</div>

	
<link href="resources/common/css/courseCss/courses.css" rel="stylesheet">
<script	src="resources/common/js/ckeditor.js"></script>
<%-- 
<%@include file="/WEB-INF/views/layout/footer.jsp"%>

 --%>