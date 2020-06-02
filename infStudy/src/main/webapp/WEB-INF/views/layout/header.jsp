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
    <link href="${contextPath }/resources/common/css/header.css" rel="stylesheet">
    <link href="${contextPath }/resources/common/css/footer.css" rel="stylesheet">

</head>
<body>
<c:if test="${!empty login}">
<div class="container">
    <header class="head">
            <div class="header_div">
                <div class="box icon"><a href="/">InfStudy</a></div>
                <div class="box text_hover lecture_list"><a href="${contextPath }/courses" class="list_a">강의들</a>
                    <ul>
                       <c:forEach var="list" items="${categoryList }">
                           <li><a href="${contextPath }/courses?category_name=${list.name}">${list.name }</a></li>
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
                                <li><a href="${contextPath }/profile"><span class="glyphicon glyphicon-user" /> 내프로필보기</a></li>
                                <li><a href="${contextPath }/myLecture"><span class="glyphicon glyphicon-tasks" /> 수강중인강의</a></li>
                                <li><a href="${contextPath }/myQnA"><span class="glyphicon glyphicon-comment" /> 내질문답변</a></li>
                                <c:choose>
                                	<c:when test="${login.i_no > 0 }"></c:when>
                                	<c:otherwise>
	 	                               <li><a href="#"><span class="glyphicon glyphicon-comment" id="enrollInstructor"> 지식공유자신청</a></li>
                                	</c:otherwise>
                                </c:choose>
                                <li><a href="${contextPath}/logout"><span class="glyphicon glyphicon-off" /> 로그아웃</a></li>
                            </ul>
                        </div>
                    </div>
            </div>
        </header>
       </div>
       </c:if>
       <c:if test="${empty login}">
    <div class="container2">
        <header class="head2">
            <div class="header_div2">
                <div class="box icon2"><a href="${contextPath}">InfStudy</a></div>
                <div class="box text_hover2 lecture_list2"><a href="${contextPath }/courses" class="list_a2">강의들</a>
                    <ul>
                    	<c:forEach var="list" items="${categoryList }">
	                        <li><a href="${contextPath }/courses?category_name=${list.name}">${list.name }</a></li>
                        </c:forEach>
                    </ul>
                    <div class="arrow22"></div>
                </div>
                <div class="box text_hover2 commu_list2"><a href="qna" class="list_a">커뮤니티</a>
                    <ul>
                        <li><a href="qna"><span class="glyphicon glyphicon-comment" /> 묻고답하기</a></li>
                        <li><a href="review"><span class="glyphicon glyphicon-star" /> 수강평모아보기</a></li>
                    </ul>
                    <div class="arrow222"></div>
                </div>
                <div class="box"></div>
                <div class="box">
                    <form class="search_box2">
                        <input type=text>
                    </form>
                    <div class="glass2"></div>
                </div>
                <div class="box profile_list2"><button class="loginbtn2" onclick="location.href='${contextPath}/loginForm'">로그인</button></div>
                <div class="box profile profile_list2"><button class="signupbtn2" onclick="location.href='${contextPath}/signupForm'">회원가입</button></div>
            </div>
        </header>
    </div>
    </c:if>
       
</body>

<script>

    document.getElementById('enrollInstructor').addEventListener('click', function(e){
        e.preventDefault();
        if(confirm("지식공유자로 등록하시겠습니까?")){
            location.href = "${contextPath}/user/enrollInstructor?u_no=${login.u_no}";
        }
    })
	
</script>
       
</html>