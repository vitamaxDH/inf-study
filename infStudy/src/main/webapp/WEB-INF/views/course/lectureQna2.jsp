<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
					<c:if test="${auth eq 'instructor' }">
						<li class="questions"><a href="${root }/course/${lecture_title}/addCurriculum/${lectureDetail.l_no}">강의 추가</a></li>
					</c:if>
				</ul>
			</div>
			
			<div class="qna-components">
				<div class="write-question-container">
					<c:if test="${login.auth eq 'student' }">
						<div class="btn-container">
							<button class="write-question-btn" id="write-question-btn">질문 작성</button>
						</div>
					</c:if>
				</div>
				
				<div class="search-container">
					<div class="search-bar">
						<input type="text" />
						<button>검 색</button>
					</div>
				</div>
				<div class="container">
					
					<c:forEach var="qna" items="${qnaList}">
			
						<div class="qna-container" onclick="qnaDetail('${qna.q_no}')">
							<article class="qna-box">
								<div class="header-container">
									<figure class="img-container">
										<img src="${login.img }" alt="" />
									</figure>
									<header class="title-header">
										<h1>
											${qna.qna_title }
										</h1>
									</header>
								</div>
								<div class="qna-content-container">
									<section class="content">
										${qna.qna_content }
									</section>
								</div>
							</article>
						</div> 
						
					</c:forEach>			
				</div>		
			</div>
		</section>
	</main>
</div>

<script>

	try{
		
		document.getElementById('write-question-btn').addEventListener("click", function(){
		var popupWidth = 400;
		var popupHeight = 300;
		var popupX =(window.screen.width / 2) - (popupWidth / 2)
		var popupY= (window.screen.height / 2) - (popupHeight / 2);

		window.open('${root}/qna/addQna?l_no=${lectureDetail.l_no}&lecture_title=${lectureDetail.lecture_title}', 
					'window팝업','width=' + popupWidth, 'height=' + popupHeight, 'left = ' + popupX + ',top=' + popupY);
		})
	}catch(e){}

	function qnaDetail(q_no){
		location.href = "${root}/questions/" + q_no;
	}
</script>

</body>
</html>

<link href="/resources/common/css/courseCss/lectureQna.css" rel="stylesheet">
<script	src="/resources/common/js/ckeditor.js"></script>
<%-- 
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
 --%>