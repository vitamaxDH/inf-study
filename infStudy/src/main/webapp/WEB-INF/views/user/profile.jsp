5<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
   src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/qna.css" rel="stylesheet">
<link href="resources/common/css/review.css" rel="stylesheet">
<link href="resources/common/css/userCss/profile.css" rel="stylesheet">

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
               <a href="profile"><li class="listContent_selected"><span class="glyphicon glyphicon-user"></span> 내 프로필 보기</li></a>
               <a href="myLecture"><li class="listContent"><span class="glyphicon glyphicon-tasks"></span> 수강중인 강의</li></a>
               <a href="myQnA"><li class="listContent"><span class="glyphicon glyphicon-comment"></span> 내 질문 답변</li></a>
            </ul>
         </div>
         <div class="qnaBoard">
            <div class="contentContainer">
            
               <div class="box pofile-box-head">프로필 설정</div>
               <div class="box"></div>
               <form:form class="box box-sd pofile-box" method="post" action="updateNick" modelAttribute="update">
                  <p>닉네임 변경</p>
                      <form:label path="nickname">닉네임</form:label>
                      <form:input type="text" path="nickname" class="form-control" id="nickname" placeholder="새 닉네임"></form:input>
                     <form:button type="submit" class="btn btn-default submitBtn">저장하기</form:button>
               </form:form>
               <div class="box"></div>
               <div class="box box-sd">
                    <form:form class="pofile-box" method="post" action="updatePassword" modelAttribute="update">
                       <p>비밀번호 변경<p>
                       <div class="form-group">
                         <form:label path="password">현재 비밀번호</form:label>
                         <form:input path="password" type="password" class="form-control" id="password" placeholder="암호"/>
                       </div>
                       <div class="form-group">
                         <form:label path="newPw">새 비밀번호</form:label>
                         <form:input path="newPw" type="password" class="form-control" id="newPw" placeholder="새비밀번호"/>
                       </div>
                       <div class="form-group">
                         <form:label path="newPwChk">비밀번호 확인</form:label>
                         <form:input path="newPwChk" type="password" class="form-control" id="newPwChk" placeholder="새비밀번호확인"/>
                       </div>
                       <form:button type="submit" class="btn btn-default submitBtn">저장하기</form:button>
                   </form:form>

                </div>
                <div class="box"></div>
               <div class="box box-sd pofile-box">
                  <p><a href="byeUserForm">탈퇴하기</a></p>
               </div>
               <div class="box"></div>
                </div>
            </div>
        </div>
   </div>
</body>
</html>