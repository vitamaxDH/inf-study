<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%> 
<c:set var="root" value="${pageContext.request.contextPath }"/>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 
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
			
			<div class="container">
				<div class="course_description">
					<div class="columns">
						<div class="content">
							<article class="description">
								<h3>강의 설명</h3>
							</article>
							<article class="curriculum">
								<h3>교육 과정</h3>
								<div class="curriculum_accordion">
									<div class="curriculm_header">
										<span class="curriculum_runtime"> 강의 시간 : <i class="fa fa-clock-o" aria-hidden="true"></i> OO시간OO분</span>
										<span class="curriculum_length">강의 수 : OO</span>
										<span class="select_all">모두 펼치기</span>
									</div>
									
									<!-- 강의 목록 보여주기  -->
									<!-- 클릭 이벤트 넣기 클릭 시 open 클래스 추가해서 하위 항목을 보여주도록  -->
									<c:forEach var="list" items="${curriculum_list }" varStatus="status">
																			
										<c:if test="${status.count == 1 }">
										<div class="section_cover">
											<div class="section_header">
												<div class="section_header_right">${curriculum_list[0].section }</div>
												<div class="section_header_left">
													<span class="unit_length">강의수</span>
													<span class="unit_runtime"><i class="fa fa-clock-o" aria-hidden="true"></i> 강의시간</span>
												</div>	
											</div>
											
											<!-- /course/${lecture_title}/lecture/${curriculum_no} -->
											<div class="lecture_cover">
												<a href="#">
												<div class="unit_item">
													<div class="unit_item_left"> 
														<i class="fa fa-play-circle-o" aria-hidden="true"></i> ${curriculum_list[0].curriculum_title }
													</div>
													<div class="unit_item_right"><i class="fa fa-clock-o" aria-hidden="true"></i> ${curriculum_list[0].playtime }</div>
												</div>
												</a>							
				<!-- 							</div>		 -->
										</c:if>
										
										<c:if test="${status.count ne fn:length(curriculum_list)}">
											<c:if test="${curriculum_list[status.count-1].section ne curriculum_list[status.count].section}">
											</div>
											<div class="section_cover">
												<div class="section_header">
													<div class="section_header_right">${curriculum_list[status.count].section }</div>
													<div class="section_header_left">
														<span class="unit_length">강의수</span>
														<span class="unit_runtime">강의시간</span>
													</div>
												</div>
												</div><div class="lecture_cover">
											</c:if>
											
											<!-- /course/${lecture_title}/lecture/${curriculum_no} -->											
											
											<a href="#">
											<div class="unit_item">
												<div class="unit_item_left"> 
													<i class="fa fa-play-circle-o" aria-hidden="true"></i> 
													${curriculum_list[status.count].curriculum_title }
												</div>
												<div class="unit_item_right">
													<i class="fa fa-clock-o" aria-hidden="true"></i>
													 ${curriculum_list[status.count].playtime }
												</div>
											</div>
											</a>
										</c:if>
									</c:forEach>
									</div>
									</div>
								</div>	 
							</article>
						</div>
					</div>
				</div>
			</div>
			
		</section>	
	</main>	
</div>


<script>

var section_elem = document.querySelectorAll(".section_header");

Array.from(section_elem).forEach(elem => {
    elem.addEventListener("click", function(){
        elem.classList.toggle("open");

    })
    
})

/*
  querySelectorAll() 함수는 유사배열을 반환한다.
  Array의 프로토타입 함수를 사용하려면 Array.form() 함수를 이용해서 유사배열을 배열로 변환해야한다. 
   이후에 Array.protototype.foreEach() 함수를 이용해 li 엘리먼트를 순회할 수 있다.

 출처 : http://jeonghwan-kim.github.io/2018/01/25/before-jquery.html  
 */
 
</script>


<link href="${root }/resources/common/css/courseCss/courseDetail.css" rel="stylesheet">	
<script	src="${root }/resources/common/js/ckeditor.js"></script>
<%-- 
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
 --%>
 
 
 
 
 
 
 
 
 
 
 
 