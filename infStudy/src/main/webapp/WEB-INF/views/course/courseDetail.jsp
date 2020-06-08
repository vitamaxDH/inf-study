<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ include file="/WEB-INF/views/layout/header.jsp"%> 
<%-- <%@include file="/WEB-INF/views/layout/footer.jsp"%> --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${contextPath}/resources/common/css/courseCss/lectureQna.css" rel="stylesheet">
	<link href="${contextPath}/resources/common/css/courseCss/courseDetail.css" rel="stylesheet">
	<script	src="${contextPath}/resources/common/js/ckeditor.js"></script>
   	<link href="${contextPath}/resources/common/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="detail-headBox">
        <div class="detail-head">
            <div class="box detail-imageBox">
                <div class="detail-image" style="background-image:url('/uploadFile/${lectureDetail.img }')"></div>
            </div>
            <div class="box detail-head-content">
                <div class="box"></div>
                <div class="box detail-head-name">${lectureDetail.lecture_title }</div>
                <div class="box detail-head-review">${lectureDetail.review_cnt }개의 수강평</div>
                <div class="box detail-head-review">${lectureDetail.student_cnt }명의 수강생</div>
                <div class="box detail-head-review">${lectureDetail.category }</div>
                <div class="box detail-head-text">${lectureDetail.content }</div>
                <div class="box"></div>
            </div>
        </div>
    </div>
    <div class="detail-bodyBox">
	    <div class="detail-body">
	        <div class="detail-nav">
	            <ul>
	            	<li class="nav-selected"><a href="${contextPath }/course/${lecture_title}">강의소개</a></li>
					<li><a href="${contextPath }/course/${lecture_title}/questions">질문&답변</a></li>
					<c:if test="${auth eq 'instructor' }">
	           			<li><a href="${contextPath }/course/${lecture_title}/addCurriculum/${lectureDetail.l_no}">강의추가</a></li>
	           		</c:if>
	        </div>

           <div class="curriculum">
              <div class="curriculumTitle">교육과정</div>
              <div class="curriculumTotal">
                 <span>전체 강의 수 : 8</span>&nbsp; / &nbsp;<span>전체 강의 시간 : 80 분</span>
              </div>
              <ul class="curriculumUl">
              	<c:forEach var="list" items="${curriculum_list }" varStatus="status">
              		<c:if test="${status.count == 1 }">
              			<li class="liTitle">${curriculum_list[0].section }<span>+</span></li>
						<a href="${contextPath}/course/${lectureDetail.lecture_title}/lecture/${list.c_no}">
              				<li>
              					&nbsp; ${curriculum_list[0].curriculum_title }
              					<span>${curriculum_list[0].playtime }</span>
              				</li>
              			</a>
              		</c:if>
              		
              
              		<c:if test="${status.count ne fn:length(curriculum_list)}">
              			<c:if test="${curriculum_list[status.count-1].section ne curriculum_list[status.count].section}">
              				<li class="liTitle">${curriculum_list[status.count].section }<span>+</span></li>
              			</c:if>
              			<a href="${contextPath}/course/${lectureDetail.lecture_title}/lecture/${curriculum_list[status.count].c_no}">
              				<li>&nbsp; ${curriculum_list[status.count].curriculum_title }
              					<span>${curriculum_list[status.count].playtime }</span>
           					</li>
              			</a>
              		</c:if>

              	</c:forEach>
	        	</ul>
	        	<div class="curriculumDate">
	        		<h1>공개일자</h1>
	        		<p>0000년 00월 00일<p>
	        	</div>
	        </div>
	        <div class="review">
	        	<div class="reviewTitle">수강후기</div>
	        	<div class="reviewRank">
	        		<div></div>
	        		<c:set var="rankTotal" value="${rankAvg[0]*5+rankAvg[1]*4+rankAvg[2]*3+rankAvg[3]*2+rankAvg[4]*1 }"/>
	        		<div style="text-align: center;">
	        			<h1>평점 : <fmt:formatNumber value="${rankTotal/(fn:length(lectureReview)) }" pattern=".00"/></h1>

	        			<p>${fn:length(lectureReview) }개의 수강평</p>
	        			
	        		</div>

	        		<ul>
	        			<li>5점 <progress class="progress link" max="${fn:length(lectureReview) }" value="${rankAvg[0] }"></progress></li>
	        			<li>4점 <progress class="progress link" max="${fn:length(lectureReview) }" value="${rankAvg[1] }"></progress></li>
	        			<li>3점 <progress class="progress link" max="${fn:length(lectureReview) }" value="${rankAvg[2] }"></progress></li>
	        			<li>2점 <progress class="progress link" max="${fn:length(lectureReview) }" value="${rankAvg[3] }"></progress></li>
	        			<li>1점 <progress class="progress link" max="${fn:length(lectureReview) }" value="${rankAvg[4] }"></progress></li>	        			
	        		</ul>
	        		<div></div>
	        	</div>
	        	<c:if test="${login.auth eq 'student' }">
	        	<div class="reviewButton">
	        		<c:if test="${login.auth eq 'student' }">
	        			<button id="addReviewBtn">수강평 남기기</button>
	        		</c:if>
	        	</div>
	        	</c:if>
	        	<div class="rBox close" id="rBox">
	        		<form:form modelAttribute="review" id="myForm">
	        			<form:hidden path="l_no" value="${lectureDetail.l_no }"/>
	        			<form:hidden path="u_no" value="${login.u_no }"/>
						<div class="rBoxRank">
							<form:select path="rank">
								<form:option value="1" selected="selected">★ ☆ ☆ ☆ ☆ </form:option>
								<form:option value="2">★ ★ ☆ ☆ ☆</form:option>
								<form:option value="3">★ ★ ★ ☆ ☆</form:option>
								<form:option value="4">★ ★ ★ ★ ☆</form:option>
								<form:option value="5">★ ★ ★ ★ ★</form:option>
							</form:select>
							<span>평점 : </span>
						</div>
						<form:textarea path="content" id="review_content" class="rBoxContentText" type="Text" placeholder="수강평을 입력하세요."></form:textarea>
						<div id="reviewMsg"></div>
						<div class="rBoxBtn">
							<form:button id="submitBtn">작성하기</form:button>
						</div>
					</form:form>
				</div>
	        	
	        	<c:forEach var="reviews" items="${lectureReview }" varStatus="status">	        		
		        	<div class="rBox">
						<div class="rBoxRank">
							<c:forEach begin="1" end="${reviews.rank }">
								★ 
							</c:forEach>
						</div>
						<div class="rBoxContentText">
							${reviews.review_content }
						</div>	
						<div class="rBoxDetail">
							<span>글쓴이 : ${reviews.reviewer }</span>&nbsp;&nbsp;&nbsp;
							<span>작성 시간 : ${reviews.review_reg_dt }</span>&nbsp;&nbsp;&nbsp;
							<span>강의명 : ${lectureDetail.lecture_title }</span>&nbsp;&nbsp;&nbsp;
						</div>			
					</div>
	        	</c:forEach>
				
	        </div>
	        <div class="blank"></div>
        </div>
        
        <c:if test="${login.auth eq null }">
        <!-- 사이드 메뉴 -->
        <%-- <c:if test="${auth eq null }"> --%>
			<div class="sideMenu" id="sideMenu">
				<div class="side1">${lectureDetail.lecture_title }</div>
				<button class="side2" id="take_lecture">수강신청</button>
				<button class="side3">${lectureDetail.wishlist_cnt } 위시</button>
				<div class="side4">지식공유자 : ${lectureDetail.teacher }</div>
				<div class="side4">${lectureDetail.curriculum_cnt }회 수업 , 총 ${lectureDetail.total_runtime } 수업</div>
				<div class="side4">평생 무제한 시청</div>
				<div class="side4">수강 난이도 : ${lectureDetail.difficulty }급 &nbsp;이상</div>
			</div>
		<%-- </c:if> --%>
        </c:if>
        
        
    </div>
    
    

</body>
</html>

<script>

//강의 커리큘럼 toggle 기능 삭제하기
var section_elem = document.querySelectorAll(".section_header");

Array.from(section_elem).forEach(elem => {
    elem.addEventListener("click", function(){
        elem.classList.toggle("open");
        
    })
})


	// 스크롤 이동할 때 사이드바 움직이게 하기
	try{
		var sideMenu = document.querySelector("#sideMenu");
		window.addEventListener("scroll", function(){
	 
			var yTop = window.pageYOffset;
			sideMenu.style.top = yTop - 200 + "px";
		})
	}catch(e){}

	// 수강신청
	try{
		document.getElementById("take_lecture").addEventListener("click", function(){
		
				if(confirm("수강신청하시겠습니까?")){
					location.href = "${root}/user/addPaidLecture?l_no=${lectureDetail.l_no}";
				}
		})
	}catch(e){}

	//수강평 창 열고 닫기
	try{
		document.getElementById('addReviewBtn').addEventListener('click', function(e){
			
			document.getElementById('rBox').classList.toggle('close');
		})
	}catch(e){}

	//수강평 글자수 제한하기
	try{
		var rContent = document.getElementById('review_content');
		rContent.addEventListener('keyup', function(e){
			var reviewMsg = document.getElementById('reviewMsg');
			if(rContent.value.length >500){
				reviewMsg.innerHTML = "<p style='color:red; font-weight:bold'>수강평은 500자까지 입력이 가능합니다.(" + rContent.value.length + "자/500자)</p>";

				if(rContent.value.length >510){
					rContent.value = rContent.value.substring(0, 510);
				}

			}
		})
	}catch(e){}

	// 수강평 남기기
	try{
		document.getElementById('submitBtn').addEventListener('click', function(e){
			e.preventDefault();
			var review_content = document.getElementById('review_content').value;
			var state = true;
			
			if(review_content.trim().length == 0){
				alert("수강평을 입력해주세요");
				state = false;
			}

			if(review_content.length > 500){
				alert("수강평은 500자까지 입력이 가능합니다.");
				state = false;
			}
		
			if(state){
				if(confirm("수강평을 등록하시겠습니까?")){
					var myForm = document.getElementById("myForm");
					myForm.setAttribute("action", "${contextPath}/review/enrollReview?lecture_title=${lectureDetail.lecture_title}");
					myForm.setAttribute("method", "post");
					myForm.submit();
				}
			}
		
		})
	}catch(e){}
 
</script>


<link href="${root }/resources/common/css/courseCss/courseDetail.css" rel="stylesheet">	
<script	src="${root }/resources/common/js/ckeditor.js"></script>
<%-- 
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
 --%> 
 