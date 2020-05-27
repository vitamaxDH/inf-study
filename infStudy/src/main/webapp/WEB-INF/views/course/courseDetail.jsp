<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%> 
<c:set var="root" value="${pageContext.request.contextPath }"/>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<div id="root">
	<main id="main">
		<section class="course_header_container">
			<div class="container">
				<div class="columns">
					<div class="column img_container">
						<img alt="강의 이미지" src="/uploadFile/${lectureDetail.img }">	
					</div>
					<div class="column course_title">
						<h1>${lectureDetail.lecture_title }</h1>
						<span>
							<div class="rating_star">별점 : ${lectureDetail.rank_avg }</div>
							<small>(${lectureDetail.review_cnt }개의 수강평)</small> <br />
						</span>
						<small class="student_cnt">${lectureDetail.student_cnt }명의 수강생</small> <br />
						<small class="course_skills">${lectureDetail.category }</small> <br />
					</div>
				</div>
			</div>
		</section>	
		<section class="course_description_container">
			<div class="tabs">
				<ul class="container">
					<li class="curriculum reviews"><a href="${root }/course/${lecture_title}">강의소개</a></li>
					<li class="questions"><a href="${root }/course/${lecture_title}/questions">질문 & 답변</a></li>
					<li class="questions"><a href="${root }/course/${lecture_title}/addCurriculum/${lectureDetail.l_no}">강의 추가</a></li>
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
										<span class="curriculum_runtime">
										 	강의 시간 : <i class="fa fa-clock-o" aria-hidden="true"></i> ${lectureDetail.total_runtime }
										 </span>
										<span class="curriculum_length">강의 수 : ${lectureDetail.curriculum_cnt }</span>
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
												<a href="${root }/course/${lectureDetail.lecture_title}/lecture/${list.c_no}">
												<div class="unit_item">
													<div class="unit_item_left"> 
														<i class="fa fa-play-circle-o" aria-hidden="true"></i> ${curriculum_list[0].curriculum_title }
													</div>
													<div class="unit_item_right"><i class="fa fa-clock-o" aria-hidden="true"></i> ${curriculum_list[0].playtime }</div>
												</div>
												</a>							
			
										</c:if>
										
										<c:if test="${status.count ne fn:length(curriculum_list)}">
											<c:if test="${curriculum_list[status.count-1].section ne curriculum_list[status.count].section}">
											</div>
											<div class="section_cover">
												<div class="section_header">
													<div class="section_header_right">${curriculum_list[status.count].section }</div>
													<div class="section_header_left">
														<span class="unit_length">강의수</span>
														<span class="unit_runtime"><i class="fa fa-clock-o" aria-hidden="true"></i> 강의시간</span>
													</div>
												</div>
												</div><div class="lecture_cover">
											</c:if>
											
											<!-- /course/${lecture_title}/lecture/${curriculum_no} -->											
											
											<a href="${root }/course/${lectureDetail.lecture_title}/lecture/${list.c_no}">
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
							
							<article class="course_date">
								<h4 class="sub_heading">공개일자</h4>
								<div>
									OOOO년 OO월 OO일<span class="last_update_date">(마지막 업데이트 일자 : OOOO년 OO월 OO일)</span>
								</div>
							</article>
							
							<article class="reviews" id="reviews">
								<h4 class="sub_heading">수강 후기</h4>
								<div class="review_summary">
									<div class="average">
										<span class="average_num">평점</span>
										<span class="average_star"></span>
										<h5 class="review_total">${fn:length(lectureReview) }개의 수강평</h5>
									</div>
									
									<!-- max에는 수강평 개수 value에는 해당 점수의 평점 개수 -->
									<!-- for문으로 돌리면 될 듯 -->
									<div class="progress_bars">
										<div class="review_counting">
											<label>5점</label>
											<progress class="progress link" max="7" value="6"></progress>
										</div>
										<div class="review_counting">
											<label>4점</label>
											<progress class="progress link" max="7" value="1"></progress>
										</div>
										<div class="review_counting">
											<label>3점</label>
											<progress class="progress link" max="7" value="0"></progress>
										</div>
										<div class="review_counting">
											<label>2점</label>
											<progress class="progress link" max="7" value="0"></progress>
										</div>
										<div class="review_counting">
											<label>1점</label>
											<progress class="progress link" max="7" value="0"></progress>
										</div>
									</div>
								</div>
								<div class="article_list">
								
									
									<c:forEach var="reviews" items="${lectureReview }" varStatus="status">
									
									<div class="article_container">
										<article class="review_item">
											<figure class="image">
												<img src="/uploadFile/${reviews.reviewer_img }" alt="유저 이미지" />
											</figure>
											<div class="media-content">
												<div class="content">
													<span class="rating_star">별점</span>
													<strong>${reviews.r_no} : ${reviews.reviewer }</strong>
													<small class="updated_at"><span>${reviews.review_reg_dt }</span></small> <br />
													<div class="review_body">${reviews.review_content }</div>											
												</div>
																								
												<c:forEach var="comments" items="${reviews.replies }">
												<div class="review_comments">
													<div class="article_container">
														<article class="comment">
															<figure class="image">
																<img src="/uploadFile/${reviews.reviewer_img }" alt="강사 이미지" />
															</figure>
															<div class="media-content">
																<div class="content">
																	<p>
																		<small>
																			<span class="author">${comments.rr_no} : ${comments.replier }</span>
																			<span class="updated_at">${comments.reply_reg_dt }</span>
																		</small> <br />
																		<span class="article_body">${comments.reply_content }</span>
																	</p>
																</div>
															</div>
														</article>
													</div>
												</div>
												</c:forEach>
												
												
												
											</div>
										</article>
									</div>
									
									
									</c:forEach>
									
									
									
								</div>
																
							</article>
							
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<!-- 사이드 메뉴 -->
		<nav id="sideMenu">
			<div class="container">
				<h2 class="price">${lectureDetail.price }원</h2>
				<button class="take_lecture">수강신청</button> <br />
				<button class="wishcnt">${lectureDetail.wishlist_cnt } 위시</button> <br />
				<div class="lec_summary">
					<div class="lec_info_row">	
						<i class="fa fa-user" aria-hidden="true"></i> <span>지식공유자 : <a href="#">${lectureDetail.teacher }</a></span>
					</div>
					
					<div class="lec_info_row">					
						<span>
							<i class="fa fa-clock-o" aria-hidden="true"></i>
							${lectureDetail.curriculum_cnt }회 수업 , 총 ${lectureDetail.total_runtime } 수업
						</span>
					</div>
					<div class="lec_info_row">					
						<span>평생 무제한 시청</span>
					</div>
					<div class="lec_info_row">					
						<span>수강 난이도 :  ${lectureDetail.difficulty }급 &nbsp;이상</span>
					</div>
				</div>
			</div>
		</nav>		
	</main>	
</div>
</body>



<script>

var section_elem = document.querySelectorAll(".section_header");

Array.from(section_elem).forEach(elem => {
    elem.addEventListener("click", function(){
        elem.classList.toggle("open");
        
    })
})


var sideMenu = document.querySelector("#sideMenu");

window.addEventListener("scroll", function(){

    var yTop = window.pageYOffset;
    sideMenu.style.top = yTop + 100 + "px";

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
 