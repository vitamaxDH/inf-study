<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%> 
<c:set var="root" value="${pageContext.request.contextPath }"/>


<div id="root">
	<main id="main">
		<section id="courses_section" class="section">
			<div class="container">
				<div class="columns">
					<aside class="column is-2 sidebar_left">
						<nav class="accordions category_accordions">
							<div class="accordion">
								<a href="${root }/courses" class="accordion-header">전체 강의</a>
							</div>
							<div class="accordion-header">
								<c:forEach var="asideList" items="${categoryList }">
								<div class="accordion-body">
									<a href="${root }/courses?category_name=${asideList.name}" class="accordion-content">${asideList.name }</a>
								</div>
								</c:forEach>
								<div class="insert_lecture"><a href="${root }/course/gotoAddLecturePg">강의 넣기</a></div>
							</div>
						</nav>
					</aside>
					
				
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
									<li><a href="#" class="category_link">전체 강의</a></li>
									<li><a href="#" class="category_link">웹개발</a></li>
									<c:if test="${category_name != null}">
										<li><a href="#" class="category_link">${category_name }</a></li>
									</c:if>
								</ul>
								<div class="select courses_order_select">
									<select name="order_select" id="courses_order_selector">
										<option value="seq" selected>추천순</option>
										<option value="popular">인기순</option>
										<option value="recent">최신순</option>
										<option value="rating">평점순</option>
										<option value="famous">학생수순</option>
									</select>
								</div>
								
							</nav>
							<div class="courses_container">
								<div class="columns courses_list_body">
									<c:forEach var="lectureList" items="${lectureList }">
									<div class="column">
										<div class="course course_card_item">
											<a href="${root }/course/${lectureList.title}" class="course_card_front">
												<div class="card_image">
													${lectureList.img }
												</div>
												<div class="card_content">
													<div class="course_title">
														${lectureList.title }																											
													</div>
													<div class="course_teacher">
														${lectureList.teacher }																											
													</div>
													<div class="course_rating">
															별점																										
													</div>
													<div class="course_price">
															${lectureList.price }																										
													</div>
												</div>
											</a>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
						</main>
					 	
					</div>
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