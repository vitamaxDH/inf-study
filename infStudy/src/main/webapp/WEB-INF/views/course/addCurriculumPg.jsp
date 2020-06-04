<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<link href="${contextPath}/resources/common/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/common/css/qna.css" rel="stylesheet">
<link href="${contextPath}/resources/common/css/review.css" rel="stylesheet">
<link href="${contextPath}/resources/common/css/myLecture.css" rel="stylesheet">
<script   src="${contextPath}/resources/common/js/ckeditor.js"></script>
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
         <div class="insert-body">
              <div class="insert-head">강의 추가하기</div>
              <div class="insert-form">
                  <form:form id="myForm" modelAttribute="addCurriculumVO">
                     <form:hidden path="l_no" value="${l_no }"/>
                         <div class="box form-div">
                             <form:label path="section" class="form-left">카테고리</form:label>
                             <form:select class="form-right selectInsert" path="section" id="section">
                                <c:forEach var="list" items="${sectionList }" varStatus="status">
                                    <form:option value="${list }"></form:option>
                             </c:forEach>
                                 <form:option value="직접입력" id="directInput">직접입력</form:option> 
                             </form:select>
                             <input class="form-right directInsert" type="text" disabled="true" id="inputSection"/>
                         </div>
                         <div class="box form-div">
                             <form:label path="title" class="form-left">커리큘럼 제목</form:label>
                             <form:input path="title" id="title" class="form-right" type="text"/>
                         </div>
                         <div class="box form-div">
                             <form:label path="url" class="form-left">커리큘럼 url</form:label>
                             <form:input path="url" id="url" class="form-right" type="text"/>
                         </div>
                         <div class="box form-div">
                             <form:label path="playtime" class="form-left">재생 시간</form:label>
                             <form:input path="playtime" id="playtime" class="form-right" type="text"/>
                         </div>
                         <div class="box form-div">
                             <form:button class="button1" id="submitBtn">등록하기</form:button>
                             <form:button class="button2" type="reset" id="resetBtn">다시쓰기</form:button>
                             <form:button class="button3" id="goBackBtn">뒤로가기</form:button>
                         </div>
                  </form:form>
              </div>
          </div>
      </div>
   </div>
</body>
</html>




<script>
   
   window.onload = function(){
         
      var inputStatus = false;
      
      var di = document.getElementById('directInput');
      var section = document.getElementById('section');
      var inputSection = document.getElementById('inputSection');
      
      var title = document.getElementById('title');
      var url = document.getElementById('url');
      var playtime = document.getElementById('playtime');
      
      showSection();
   
      section.addEventListener('change', showSection);

      // 섹션 클릭
      function showSection(){
         
         if(di.selected){
   
            inputStatus = true;
            console.log(inputStatus);
            inputSection.removeAttribute("disabled");
            inputSection.setAttribute("style", "background-color:white;")
         }else{
   
            inputStatus = false;
            console.log(inputStatus);
            inputSection.setAttribute("disabled", true);
            inputSection.setAttribute("style", "background-color:#eee;")
         }
      }

      // 전송
      document.getElementById('submitBtn').addEventListener('click', function(){
   
         var submitStatus = true;
         var msg = "";
   
         if(inputStatus){
            di.setAttribute("value", inputSection.value);
         }

         if(inputStatus && inputSection.value.trim().length == 0){
            msg = "섹션값을 입력해주세요";
            var submitStatus = false;
            alert(msg);
            return false;
         }
         
         if(!title.value){
            msg = "커리큘럼의 제목을 입력해주세요";
            var submitStatus = false;
            alert(msg);
            return false;
         }
   
         if(!url.value){
            msg = "커리큘럼의 url을 입력해주세요";
            var submitStatus = false;
            alert(msg);
            return false;
         }
   
         if(!playtime.value){
            msg = "커리큘럼의 재생시간을 입력해주세요";
            var submitStatus = false;
            alert(msg);
            return false;
         }
   
         if(submitStatus){
            var submit = document.getElementById('myForm');
            submit.setAttribute("action", "${root}/course/${lecture_title}/addCurriculum");
            submit.setAttribute("method", "post");
            submit.submit();
         }

      });

      // 뒤로가기
      document.getElementById('goBackBtn').addEventListener('click', function(e){
         e.preventDefault();
         history.back();
      });
   }

</script>





<style>
.selectInsert{
    width: calc(25% - 50px)!important;
    float: left!important;
    margin-right: 0!important;
}
.directInsert{
    width: calc(58% - 50px)!important;
}
body{
   height: 800px;
}
.qnaMain{
   height: fit-content;
}
.insert-body{
    position: absolute;
    left: 0;
    right: 0;
    margin:0 auto;
    width:1200px;
    height: 600px;
}
.insert-head{
    font-size: 25px;
    line-height: 55px;
    font-weight: bold;
    color: gray;
    margin:20px 0;
}
.insert-form{
    box-shadow: 1px 1px 3px 1px gray;
}
.insert-form form{
    display: grid;
    grid-template-rows: 20% 20% 20% 20% 20% ;
    width: 100%;
    height: 100%;
}
.form-div{
    width: 100%;
    height: 100%;
}
.form-left{
    float:left;
    width: 20%;
    height: 100%;
    line-height: 100px;
    font-size:17px;
    color:gray;
    padding-left:40px;
}
.form-right{
    float:right;
    width: calc(80% - 50px);
    height: 40%;
    border-radius: 5px;
    border: 1px solid gray;
    padding-left: 10px;
}
.form-div button:focus{
    background-color: white;
    color: black;
}
.form-right option{
    height: 50px;
}
.form-div input, .form-div select{
    margin-top: 30px;
    margin-right:50px;
    line-height: 40px;
}
.form-div textarea{
    height: 160px;
    margin-top: 20px;
    margin-right:50px;
    padding-top: 20px;
    resize: none;
}
.form-right-img{
    height: 160px;
    width: calc(80% - 50px);
    margin-top: 20px;
    margin-right:20px;
    padding-top: 20px;
    border:1px solid gray;
    border-radius: 5px;
    padding-left: 20px;
}
.form-div button{
    position: relative;
    width: 25%;
    bottom: 40px;
    height: 50px;
    margin-top: 50px;
    color: white;
    font-size: 20px;
    font-weight: bold;
    border: none;
    border-radius: 5px;
}
.button1{
    left:10%;
    background-color: rgb(0,193,113);
}
.button2{
    left: 12%;
    background-color: rgb(255,102,0);
}
.button3{
    left:14%;
    background-color: red;
}
</style>