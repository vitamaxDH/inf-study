<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${contextPath}/resources/common/css/courseCss/lectureQna.css" rel="stylesheet">
	<script	src="${contextPath}/resources/common/js/ckeditor.js"></script>
   	<link href="${contextPath}/resources/common/css/bootstrap.min.css" rel="stylesheet">
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
	            	<li><a href="${contextPath }/course/${lecture_title}">강의소개</a></li>
					<li class="nav-selected"><a href="${contextPath }/course/${lecture_title}/questions">질문&답변</a></li>
					<li><a href="${contextPath }/course/${lecture_title}/addCurriculum/${lectureDetail.l_no}">강의추가</a></li>
	        </div>
	        <div class="detail-questionAndSearch">
	            <div class="box insertQ">
	            	<%-- <c:if test="${login.auth eq 'student' }"> --%>
						<button id="write-question-btn">질문작성</button>
					<%-- </c:if> --%>
	            </div>
	            <div class="box searchBox">
					<form class="searchBoxDiv"  method="get">
						<input type="text" name="keyword">
						<button type="button">검색</button>
						<div id="inputError"></div>
					</form>
				</div>
	        </div>
	        <div class="detail-question">
	        
				<!-- 질문하기 작성창 -->
				<div class="qBox closeHere"  id="question_window">
					<div class="box qBoxImage">
						<span class="glyphicon glyphicon-question-sign"></span>
					</div>
					<div class="box qBoxContent">
						<form:form modelAttribute="qna" id="myQForm">
							<form:hidden path="u_no" value="${login.u_no }"/>
							<form:hidden path="l_no" value="${lectureDetail.l_no }"/>
							<div class="qBoxContentName">
								<form:input path="title" id="qTitle" maxlength="102" placeholder="질문 제목을 입력하세요."/>
								<div id="qTitleError"></div>
							</div>
							<div class="qBoxContentText">
								<form:textarea path="content" id="qContent" placeholder="질문 내용을 입력하세요."></form:textarea>
								<div id="qContentError"></div>
							</div>
							<div class="box qBoxBtn">
								<form:button id="myQBtn">작성하기</form:button>
				            </div>
				        </form:form>
					</div>
				</div>
				
				
	        	<c:forEach var="qna" items="${qnaList}">
		        	<div class="qBox">
			            <div class="box qBoxImage">
							<span class="glyphicon glyphicon-question-sign"></span>
						</div>
			            <div class="box qBoxContent">
			                <div class="qBoxContentName">${qna.qna_title} ${qna.q_no }</div>
			                <div class="qBoxContentText">${qna.qna_content}</div>
			            </div>
       					<div class="box"></div>
						<div class="box qBoxBtn">
 							<button class="aBtn">답변달기</button>
						</div>
			        </div>
			        <!-- 답변하기 작성창 -->
					<div class="qBox aBox closeHere">
						<div class="box qBoxImage">
							<span class="glyphicon glyphicon-exclamation-sign"></span>
						</div>
						<div class="box qBoxContent">
				        	<form:form modelAttribute="qnaReply" class="replyForm">
				        		<form:hidden path="q_no" value="${qna.q_no }"/>
				        		<form:hidden path="u_no" value="${login.u_no }"/>
								<div class="qBoxContentText">
									<form:textarea path="content" class="rContent" placeholder="답변 내용을 입력하세요."></form:textarea>
								</div>
								<div class="box qBoxBtn">
									<form:button class="replyBtn">작성하기</form:button>
					            </div>
							</form:form>
						</div>
					</div>
					
					<c:forEach var="qr" items="${qna.qrList }">
					<!-- 답변하기 출력창 -->
					<div class="qBox aBox">
						<div class="box qBoxImage">
							<span class="glyphicon glyphicon-exclamation-sign"></span>
						</div>
						<div class="box qBoxContent">
							<div class="qBoxContentName">${qr.q_no}, ${qr.reg_dt }</div>
							<div class="qBoxContentText">${qr.content }</div>
						</div>
					</div>
					</c:forEach>
			    </c:forEach>
				
			</div>
			<div class="blank"></div>
        </div>
        
        
        <!-- 사이드 메뉴 -->
        <%-- <c:if test="${auth eq null }"> --%>
			<div class="sideMenu" id="sideMenu">
				<div class="side1">${lectureDetail.lecture_title }</div>
				<button class="side2">수강신청</button>
				<button class="side3">${lectureDetail.wishlist_cnt } 위시</button>
				<div class="side4">지식공유자 : ${lectureDetail.teacher }</div>
				<div class="side4">${lectureDetail.curriculum_cnt }회 수업 , 총 ${lectureDetail.total_runtime } 수업</div>
				<div class="side4">평생 무제한 시청</div>
				<div class="side4">수강 난이도 : ${lectureDetail.difficulty }급 &nbsp;이상</div>
			</div>
		<%-- </c:if> --%>
        
        
        
    </div>
    
    

</body>
</html>

 
 
 
 
<script>

	document.getElementById('write-question-btn').addEventListener('click', function(){
		document.getElementById('question_window').classList.toggle("closeHere")
	})


	Array.from(document.getElementsByClassName('aBtn')).forEach(function(elem){
		elem.addEventListener('click', function(){
			this.closest('.qBox').nextSibling.nextSibling.nextSibling.nextSibling.classList.toggle('closeHere');
		})
	})

	try{
		document.getElementById('myQBtn').addEventListener("click", function(e){
			e.preventDefault();
			var qTitle = document.getElementById("qTitle").value;
			var qContent = document.getElementById("qContent").value;
			var status = true;

			if(qTitle.trim().length == 0){
				alert("제목을 입력해주세요");
				status = false;
				return false;
			}
			if(qContent.trim().length == 0){
				alert("질문을 입력해주세요");
				status = false;
				return false;
			}

			if(qTitle.length > 100){
				alert("제목은 100자까지 입력이 가능합니다.");
				status =false;
				return false;
			}

			if(qContent.length > 1000){
				alert("질문은 1000자까지 입력이 가능합니다.");
				status=  false;
				return false;
			}

			if(status){
				var myQForm = document.getElementById('myQForm');
				myQForm.setAttribute("action", "${contextPath}/qna/enrollQna?lecture_title=${lectureDetail.lecture_title}");
				myQForm.setAttribute("method", "post");
				myQForm.submit();
			}


		})
	}catch(e){}
	


	document.getElementById('qTitle').addEventListener('keyup', function(){

		var qVal = this.value;
		if(qVal.length > 100){
			document.getElementById('qTitleError').innerHTML = "<p><small style='color:red'>제목은 100자까지 입력이 가능합니다.</small></p>"
		}else{
			document.getElementById('qTitleError').innerHTML = "";

		}
	})

	document.getElementById('qContent').addEventListener('keyup', function(){

		var qVal = this.value;
		if(qVal.length > 1000){
			document.getElementById('qContentError').innerHTML = "<p><small style='color:red font-weight:bold'>질문은 1000자까지 입력이 가능합니다.</small></p>"
		}else{
			document.getElementById('qContentError').innerHTML = "";

		}
	})



	Array.from(document.getElementsByClassName('replyForm')).forEach(function(elem){
		
		elem.childNodes[7].childNodes[1].addEventListener('click', function(e){
			e.preventDefault();
			var rContent = elem.childNodes[5].childNodes[1];
			var status = true;
			if(rContent.value.trim().length == 0){
				alert("답변을 입력해주세요");
				status = false;
				return false;
			}

			if(status){
				elem.setAttribute('action', '${contextPath}/qna/enrollQnaReply?lecture_title=${lectureDetail.lecture_title}');
				elem.setAttribute('method', 'post');
				elem.submit();
			}
		})

	})



</script>
 