<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
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
</head>
<body>
	<article class="container home_body">
        <div class="row">
            <div class="col-sm-1 col-md-12 div1_1"></div>
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
        	<c:forEach var="list" items="${homeDto3}" begin="1" end="7">
	            <a href="#">
	                <div class="col-md-6 div3_1">${list.main_category}</div>
	            </a>
            </c:forEach>
        </div>
        <div class="col-sm-1 col-md-12 div_subTitle">InfStudy 신규 강의</div>
        <div class="row width1200">
        	<c:forEach var="list" items="${homeDto}" begin="0" end="3">
	            <a href="#">
	                <div class="col-md-3 div4_1">
	                    <div class="div4_1_image"></div>
	                    <div class="div4_1_text">
	                    	<div class="div4_main_title">${list.main_title}</div>
	                    	<div class="div4_main_writer">${list.main_writer}</div>
	                    	<div class="div4_main_rank">
								<c:forEach begin="1" end="${list.main_rank}">
								★&nbsp; 
								</c:forEach>
								<c:forEach begin="1" end="${5 - list.main_rank}">
								☆&nbsp;
								</c:forEach>
							</div>
	                    </div>
	                    <div class="div4_1_cover">
	                    	<div class="div4_cover_main_title">${list.main_title}</div>
	                    	<div class="div4_cover_main_content">${list.main_content}</div>
	                    </div>
	                </div>
	            </a>
            </c:forEach>
        </div>
        <div class="col-sm-1 col-md-12 div_subTitle">InfStudy 인기 강의</div>
        <div class="row width1200">
        	<c:forEach var="list" items="${homeDto2}" begin="0" end="3">
	            <a href="#">
	                <div class="col-md-3 div5_1">
	                    <div class="div5_1_image"></div>
	                    <div class="div5_1_text">
	                    	<div class="div5_main_title">${list.main_title}</div>
	                    	<div class="div5_main_writer">${list.main_writer}</div>
	                    	<div class="div5_main_rank">
								<c:forEach begin="1" end="${list.main_rank}">
								★&nbsp; 
								</c:forEach>
								<c:forEach begin="1" end="${5 - list.main_rank}">
								☆&nbsp;
								</c:forEach>
							</div>
	                    </div>
	                    <div class="div5_1_cover">
	                    	<div class="div5_cover_main_title">${list.main_title}</div>
	                    	<div class="div5_cover_main_content">${list.main_content}</div>
	                    </div>
	                </div>
	            </a>
            </c:forEach>
        </div>
    </article>
</body>
</html>