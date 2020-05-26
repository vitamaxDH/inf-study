<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="/resources/common/css/header.css" rel="stylesheet">
    <link href="/resources/common/css/footer.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <header class="head">
            <div class="header_div">
<<<<<<< HEAD
                <div class="box icon"><a href="/">InfStudy</a></div>
                <div class="box text_hover lecture_list"><a href="${contextPath }/courses" class="list_a">강의들</a>
                    <ul>
                    	<c:forEach var="list" items="${categoryList }">
                        <li><a href="${contextPath }/courses?category_name=${list.name}">${list.name}</a></li>
=======
                <div class="box icon"><a href="${contextPath}">InfStudy</a></div>
                <div class="box text_hover lecture_list"><a href="${contextPath }/courses" class="list_a">강의들</a>
                    <ul>
                    	<c:forEach var="list" items="${categoryList }">
	                        <li><a href="${contextPath }/courses?category_name=${list.name}">${list.name }</a></li>
>>>>>>> 352139a99b62a66654aaefded2cb82fcd16de189
                        </c:forEach>
                    </ul>
                    <div class="arrow"></div>
                </div>
                <div class="box text_hover commu_list"><a href="qna" class="list_a">커뮤니티</a>
                    <ul>
                        <li><a href="qna"><span class="glyphicon glyphicon-comment" /> 묻고답하기</a></li>
                        <li><a href="review"><span class="glyphicon glyphicon-star" /> 수강평모아보기</a></li>
                    </ul>
                    <div class="arrow2"></div>
                </div>
                <div class="box"></div>
                <div class="box"></div>
                <div class="box">
                    <form class="search_box">
                        <input type=text>
                    </form>
                    <div class="glass"></div>
                </div>
                <div class="box profile profile_list"><button>Profile</button></a>
                        <div class="profile_list_div">
                            <ul class="profile_list_div_ul">
                                <li><a href="#"><span class="glyphicon glyphicon-user" /> 내프로필보기</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-play-circle" /> 이어서학습하기</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-tasks" /> 수강중인강의</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-comment" /> 내질문답변</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-off" /> 로그아웃</a></li>
                            </ul>
                        </div>
                    </div>
            </div>
        </header>
       </div>
       </body>
       </html>