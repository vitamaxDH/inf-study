<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>home</title>
   <link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
   <script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <link href="resources/common/css/home.css" rel="stylesheet"> 
	<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.1/css/swiper.css"> 
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.1/css/swiper.min.css"> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.1/js/swiper.js"></script> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.1/js/swiper.min.js"></script>
</head>

<style>
.swiper-pagination{
    left: 0px;
    right: 0;
    top: 300px;
}
.swiper-pagination-bullet{
    width: 15px;
    height: 15px;
    margin: 0 5px;
}
.swiper-pagination-bullet-active{
    background: rgb(0,196,113);
}
</style>

<body>
   <article class="container home_body">
        <div class="row">
            <div class="col-sm-1 col-md-12 div1_1">
            	<!-- 여기 이미지 -->
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide" style="background-image: url('resources/common/images/back1.png')"></div>
						<div class="swiper-slide" style="background-image: url('resources/common/images/back2.jpg"></div>
						<div class="swiper-slide" style="background-image: url('resources/common/images/back3.jpg"></div>
					</div>
				</div>
			</div>

			<!-- If we need pagination -->
			<div class="swiper-pagination"></div>
		</div>
        <div class="row width1200">
            <div class="col-xs-12 div2_1">
                <h3>성장기회의 평등을 추구합니다</h3>
                <div class="div2_1_box">
                    <input class="div2_1_input" type=text placeholder="배우고 싶은 지식을 입력하세요">
                    <button class="div2_1_glass glyphicon glyphicon-search" />
                </div>
            </div>
        </div>
        <div class="col-sm-1 col-md-12 div_subTitle">둘러보기</div>
        <div class="row width1200">

        	<c:forEach var="list" items="${categoryList }" begin="0" end="6">
	            <a href="${contextPath }/courses?category_name=${list.name}">
	                <div class="col-md-6 div3_1">${list.name }</div>
	            </a>

            </c:forEach>
        </div>
        <div class="col-sm-1 col-md-12 div_subTitle">InfStudy 신규강의</div>
        <div class="row width1200">
           <c:forEach var="list" items="${homeDto}" begin="0" end="3">
               <a href="${contextPath }/course/${list.main_title}">
                   <div class="col-md-3 div4_1">
                       <div class="div4_1_image" style="background-image: url('/uploadFile/${list.main_imageLink}');"></div>
                       <div class="div4_1_text">
                          <div class="div4_main_title">${list.main_title}</div>
                          <div class="div4_main_writer">${list.main_writer}</div>
                       </div>
                       <div class="div4_1_cover">
                          <div class="div4_cover_main_title">${list.main_title}</div>
                          <div class="div4_cover_main_content">${list.main_content}</div>
                       </div>
                   </div>
               </a>
            </c:forEach>
        </div>
    </article>
</body>
</html>


<script>
	new Swiper('.swiper-container', {
		//무한 반복
	    loop: true,
		// 현재 페이지를 나타내는 점이 생깁니다. 클릭하면 이동합니다.
		pagination: {
			el: '.swiper-pagination',
			type: 'bullets',
	        clickable: true,
		},
		// 3초마다 자동으로 슬라이드가 넘어갑니다. 1초 = 1000
		autoplay: {
			delay: 3000,
		},
	});
</script>
