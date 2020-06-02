<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
<link href="resources/common/css/review.css" rel="stylesheet">
<link href="resources/common/css/myLecture.css" rel="stylesheet">
<script	src="resources/common/js/ckeditor.js"></script>
</head>
<body>
	<div class="qnaBody">
		<div class="qnaHeader">
			<div class="qnaHeaderDiv">
				<h1>강의들</h1>
				<p>모두가 함께하는 커뮤니티</p>
				<p>함께 배우고, 함께 익혀요.</p>
			</div>
		</div>
		<div class="qnaMain">
			<div class="qnaNavi">
				<ul>
					<a href="${root }/courses"><li class="listTitle">전체 강의</li></a>
                   	<c:forEach var="asideList" items="${categoryList }">
	                    <a href="${root }/courses?category_name=${asideList.name}"><li class="listContent">${asideList.name }</li></a>
                    </c:forEach>
                    <br>
					<li class="listTitle"><a href="${root }/course/gotoAddLecturePg">강의 넣기</a></li>
				</ul>
			</div>
			<div class="qnaBoard">
				<div class="contentContainer">
					<div class="box lecture-head">
						<p>
							<c:if test="${category_name == null}">전체 강의</c:if>
							<c:if test="${category_name != null}">${category_name }</c:if>
						</p>
					</div>
					<div class="box">
						<div class="searchBox">
							<form class="searchBoxDiv" role="form" method="get" maxlength="11" placeholder="강의 검색하기" id="searchInput">
								<input type="text" name="keyword" id="keywordInput">
								<button type="button" id="searchBtn" id="findLec">검색</button>
								<div id="inputError"></div>	
							</form>
						</div>
					</div>
					<div class="box contentBox">
						<c:forEach var="lectureList" items="${lectureList }">
				            <a href="${root }/course/${lectureList.title}"">
				                <div class="col-md-3 div4_1">
				                    <div class="div4_1_image" style="background-image: url('/uploadFile/${lectureList.img}');"></div>
				                    <div class="div4_1_text">
				                    	<div class="div4_main_title">${lectureList.title }</div>
				                    	<div class="div4_main_writer">${lectureList.teacher }</div>
				                    </div>
				                    <div class="div4_1_cover">
				                    	<div class="div4_cover_main_title">${lectureList.title}</div>
				                    	<div class="div4_cover_main_content">${lectureList.content}</div>
				                    </div>
				                </div>
				            </a>
			            </c:forEach>
					</div>
				</div>
			</div>
			<div class="qnaBoqrdPaging">
				<nav>
					<ul class="pagination">
						<c:choose>
							<c:when test="${pageBean.prevPage <= 0 }"></c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${category_name ne null }">
										<li><a href="${root }/courses?category_name=${category_name }&page=${pageBean.prevPage}">이전</a></li>
									</c:when>

									<c:otherwise>
										<li><a href="${root }/courses?page=${pageBean.prevPage}" >이전</a></li>
									</c:otherwise>
								</c:choose>

							</c:otherwise>
						</c:choose>

						<c:forEach var='idx' begin="${pageBean.min }"
							end='${pageBean.max }'>
							<c:choose>
								<c:when test="${idx == pageBean.currentPage }">
									<c:choose>
										<c:when test="${category_name ne null }">
											<li><a href="${root }/courses?category_name=${category_name }&page=${idx}" >${idx }</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${root }/courses?page=${idx}">${idx }</a></li>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${category_name ne null }">
											<li><a href="${root }/courses?category_name=${category_name }&page=${idx}">${idx }</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${root }/courses?page=${idx}">${idx }</a> </li>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:choose>
							<c:when test="${pageBean.max >= pageBean.pageCnt }"></c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${category_name ne null }">
										<li><a href="${root }/courses?category_name=${category_name }&page=${pageBean.nextPage}" >다음</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${root }/courses?page=${pageBean.nextPage}" >다음</a></li>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
			</div>
		</div>
	</div>

</body>
</html>

<script>
	const searchInput = document.getElementById('searchInput');
	const inputError = document.getElementById('inputError');
	
	searchInput.addEventListener('keyup',function(e){
	    const inputVal = e.target.value;
	    if (inputVal.length > 10){
	    	inputError.innerHTML = '<p style="color:red;">입력값이 10자를 초과했습니다.<br>글자는 10자까지 입력이 가능합니다.</p>';
	    	      
	    }else{
	    	inputError.innerHTML = '';
	    }

	    if(event.keyCode == 13){

		    const inputVal = searchInput.value;

		    if('${category_name}'.trim().length != 0){
			    
			    location.href = "?lecture_title=" + inputVal + "&category_name=${category_name}";
		    }else{
		    	location.href = "?lecture_title=" + inputVal;
		    }	    	
		}
	});
	

	const findLec = document.getElementById("findLec");
	findLec.addEventListener('click', function(e){
	    const inputVal = searchInput.value;

	    if('${category_name}'.trim().length != 0){
		    
		    location.href = "?lecture_title=" + inputVal + "&category_name=${category_name}";
	    }else{
	    	location.href = "?lecture_title=" + inputVal;
	    }

	})
	
</script>

	
