<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath} "/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>footer</title>
    <link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="resources/common/css/header.css" rel="stylesheet">
    <link href="resources/common/css/footer.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <header class="head">
        <div class="header_div">
            <div class="box icon"><a href="home.html">InfStudy</a></div>
            <div class="box text_hover menu_list"><a href="/courses" style="font-size:15px !important;font-weight: 700;">강의들</a>
                <ul>
                    <li><a href="#">HTML/CSS</a></li>
                    <li><a href="#">웹 개발</a></li>
                    <li><a href="#">JavaScript</a></li>
                    <li><a href="#">Java</a></li>
                    <li><a href="#">Front-End</a></li>
                    <li><a href="#">Python</a></li>
                    <li><a href="#">Back-End</a></li>
                    <li><a href="#">웹 퍼블리싱</a></li>
                    <li><a href="#">Spring</a></li>
                    <li><a href="#">Node.js</a></li>
                    <li><a href="#">React</a></li>
                </ul>
                <div class="arrow"></div>
            </div>
            <div class="box text_hover menu_list">커뮤니티
                <ul>
                    <li><a href="#"><span class="glyphicon glyphicon-comment" /> 묻고답하기</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-star" /> 수강평모아보기</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-bullhorn" /> 인프런공지사항</a></li>
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
            <div class="box profile profile_list"><a href="dashboard"><span class="glyphicon glyphicon-user" />
                    <div class="profile_list_div">
                        <div class="profile_list_div_div1"><a href="#"><span class="glyphicon glyphicon-user">ChanJu</a>
                        </div>
                        <ul class="profile_list_div_ul">
                            <li><a href="#"><span class="glyphicon glyphicon-play-circle"></span> 이어서 학습하기</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-tasks"></span> 수강중인 강의</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-comment"></span> 내 질문 답변</a></li>
                        </ul>
                        <div class="profile_list_div_div2">
                            <div class="profile_list_div_div2_logout"><a href="#">로그아웃</a></div>
                        </div>
                    </div>
                </a></div>
        </div>
    </header>
