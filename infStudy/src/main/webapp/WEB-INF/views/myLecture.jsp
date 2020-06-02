<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myLecture</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
<link href="resources/common/css/review.css" rel="stylesheet">
<link href="resources/common/css/myLecture.css" rel="stylesheet">
</head>
<body>
	 <div class="qnaBody">
		<div class="qnaHeader">
            <div class="qnaHeaderDiv">
                <h1>나의 프로필</h1>
                <p>모두가 함께하는 커뮤니티</p>
                <p>InfStudy에서 함께 공부해요</p>
            </div>
        </div>
		<div class="qnaMain">
			<div class="qnaNavi">
				<ul>
					<li class="listTitle">함께 공부해요</li>
					<a href="profile"><li class="listContent"><span class="glyphicon glyphicon-user"></span> 내 프로필 보기</li></a>
					<a href="myLecture"><li class="listContent_selected"><span class="glyphicon glyphicon-tasks"></span> 수강중인 강의</li></a>
					<a href="myQnA"><li class="listContent"><span class="glyphicon glyphicon-comment"></span> 내 질문 답변</li></a>
				</ul>
			</div>
			<div class="qnaBoard">
				<div class="contentContainer">
					<div class="box lecture-head">
						<p>내 강의</p>
					</div>
					<div class="box">
						<div class="searchBox">
							<form class="searchBoxDiv" role="form" method="get">
								<input type="text" name="keyword" id="keywordInput">
								<button type="button" id="searchBtn">검색</button>
							</form>
						</div>
					</div>
					<div class="box contentBox">
						<c:forEach var="list" items="${myLectureList }">
				            <a href="${contextPath }/course/${list.title}">
				                <div class="col-md-3 div4_1">
				                    <div class="div4_1_image" style="background-image: url('/uploadFile/${list.img}');"></div>
				                    <div class="div4_1_text">
				                    	<div class="div4_main_title">${list.title}</div>
				                    	<div class="div4_main_writer">${list.teacher}</div>
				                    </div>
				                    <div class="div4_1_cover">
				                    	<div class="div4_cover_main_title">${list.title}</div>
				                    	<div class="div4_cover_main_content">${list.content}</div>
				                    </div>
				                </div>
				            </a>
			            </c:forEach>
					</div>
                </div>
                <div class="qnaBoqrdPaging">
						<nav>
							<ul class="pagination">
								
								<!-- 이전화면 -->
								<li><a href="#">start</a></li>
								<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								
								<!-- 페이지 선택 -->
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">6</a></li>
								<li><a href="#">7</a></li>
								<li><a href="#">8</a></li>
								<li><a href="#">9</a></li>
								<li><a href="#">10</a></li>
							    
								<!-- 다음화면 -->
							    <li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
								<li><a href="#">end</a></li>
							    
							</ul>
						</nav>
					</div>
            </div>
        </div>
	</div>
</body>
</html>
