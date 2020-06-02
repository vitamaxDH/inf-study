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
    <div class="detail-headBox">
        <div class="detail-head">
            <div class="box detail-imageBox">
                <div class="detail-image" style="background-image:url('')"></div>
            </div>
            <div class="box detail-content">
                <div class="box">강의명</div>
                <div class="box">N 개의 수강평</divp>
                <div class="box">N 개의 수강생</div>
                <div class="box">
		                    이 div는 강의 상세 설명을 적어두는 div로 어쩌고저쩌고 이 div는 강의 상세 설명을 적어두는 div로 어쩌고저쩌고 <br/>
		                    이 div는 강의 상세 설명을 적어두는 div로 어쩌고저쩌고 이 div는 강의 상세 설명을 적어두는 div로 어쩌고저쩌고
                </div>
            </div>
        </div>
    </div>
    <div class="detail-body">
        <div class="detail-nav">
            <div>강의소개</div>
            <div>질문&답변</div>
            <div>강의추가</div>
        </div>
        <div class="detail-question&search">
            <div>질문작성</div>
            <div>
                <input type="Texts">
                <button>검색</button>
            </div>
        </div>
        <div class="detail-question">
            <div>질문자 이미지</div>
            <div>
                <div>질문자 이름</div>
                <div>이것은 질문 ㅋㅋ 이것은 질문 ㅋㅋ 이것은 질문</div>
            </div>
        </div>
    </div>

</body>
</html>

<link href="/resources/common/css/courseCss/lectureQna.css" rel="stylesheet">
<script	src="/resources/common/js/ckeditor.js"></script>
<%-- 
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
 --%>
 
 
 
 
 
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
 