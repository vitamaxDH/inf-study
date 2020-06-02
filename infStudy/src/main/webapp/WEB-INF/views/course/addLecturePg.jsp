<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
              <div class="insert-head">강의 넣기</div>
              <div class="insert-form">
					<form:form modelAttribute="addLecture" id="myForm" enctype="multipart/form-data">
               			<div class="box form-div">
                         <form:hidden path="i_no" value="${login.i_no }"/>
                       	 <form:label path="ctg_no" class="form-left">카테고리</form:label>
							<form:select path="ctg_no" class="form-right selectInsert" id="ctg_no">
								<c:forEach var="category" items="${categoryList }">
                            		<form:option value="${category.ctg_no }">${category.name }</form:option>
                      		  </c:forEach>
                             <form:option value="${fn:length(categoryList)+1 }" id="directInput">직접입력</form:option>                         
                          </form:select>
<%--                           <c:forEach var="category" items="${categoryList }">
                          	<form:hidden path="${category.name }"/>
                          </c:forEach> --%>
                          <form:input class="form-right directInsert" type="text" path="ctg_name" disabled="true" id="ctg_name"/>                          
                      </div>
                      <div class="box form-div">
                          <form:label path="title" class="form-left">강의 제목</form:label>
                          <form:input path="title" id="title" class="form-right" type="text"/>
                      </div>
                      <div class="box form-div">
                          <form:label path="price" class="form-left">가격</form:label>
                          <form:input path="price" id="price" class="form-right" type="text"/>
                      </div>
                      <div class="box form-div">
                          <form:label path="difficulty" class="form-left">난이도</form:label>
                          <form:input path="difficulty" id="difficulty" class="form-right" type="text"/>
                      </div>
                      <div class="box form-div">
                          <form:label path="content" class="form-left">강의 소개</form:label>
                          <form:textarea path="content" id="content" class="form-right"></form:textarea>
                      </div>
                      <div class="box form-div">
                          <form:label path="lectureImg" class="form-left">강의 프로필</form:label>
                          <form:input path="lectureImg" id="lectureImg" class="form-right-img" type="file"/>
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
    var ctg_no = document.getElementById('ctg_no');
    var ctg_name = document.getElementById('ctg_name');
    var title = document.getElementById('title');
    var price = document.getElementById('price');
    var difficulty = document.getElementById('difficulty');
    var content = document.getElementById('content');
    var lectureImg = document.getElementById('lectureImg');
    
    showSection();
 
    ctg_no.addEventListener('change', showSection);

    // 섹션 클릭
    function showSection(){
       
       if(di.selected){
 
          inputStatus = true;
          console.log(inputStatus);
          ctg_name.removeAttribute("disabled");
          ctg_name.setAttribute("style", "background-color:white;")
       }else{
 
          inputStatus = false;
          console.log(inputStatus);
          ctg_name.setAttribute("disabled", true);
          ctg_name.setAttribute("style", "background-color:#eee;")
       }
    }

    // 전송
    document.getElementById('submitBtn').addEventListener('click', function(e){

		e.preventDefault();
		var submitStatus = true;
		var msg = "";
 
       if(inputStatus){
          ctg_name.setAttribute("value", ctg_name.value);
       }

       if(inputStatus && ctg_name.value.trim().length == 0){
          msg = "카테고리값을 입력해주세요";
          var submitStatus = false;
          alert(msg);
          return false;
       }
       
        if(!title.value){
          msg = "강의 제목을 입력해주세요";
          var submitStatus = false;
          alert(msg);
          return false;
       }
 
       if(!price.value){
          msg = "가격을 입력해주세요";
          var submitStatus = false;
          alert(msg);
          return false;
       }
 
       if(!difficulty.value){
          msg = "난이도를 입력해주세요";
          var submitStatus = false;
          alert(msg);
          return false;
       }

       if(!content.value){
          msg = "강의 소개를 입력해주세요";
          var submitStatus = false;
          alert(msg);
          return false;
       }

       if(!lectureImg.value){
          msg = "강의 프로필을 추가해주세요";
          var submitStatus = false;
          alert(msg);
          return false;
       }
 
       if(submitStatus){
          var submit = document.getElementById('myForm');
          submit.setAttribute("action", "${root }/course/addLecture");
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
body{
   height: 1150px;
}
.insert-body{
    position: absolute;
    left: 0;
    right: 0;
    margin:0 auto;
    width:1200px;
    height: 1000px;
}

.selectInsert{
    width: calc(25% - 50px)!important;
    float: left!important;
    margin-right: 0!important;
}

.directInsert{
    width: calc(58% - 50px)!important;
}

.insert-head{
    font-size: 25px;
    line-height: 55px;
    font-weight: bold;
    color: gray;
    margin:20px 0;
}
.insert-form{
    width: 90%;
    height: 80%;
    box-shadow: 1px 1px 3px 1px gray;
}
.insert-form form{
    display: grid;
    grid-template-rows: 10% 10% 10% 10% 25% 25% 10% ;
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
    line-height: 80px;
    font-size:17px;
    color:gray;
    padding-left:40px;
}
.form-right{
    float:right;
    width: calc(80% - 50px);
    height: 50%;
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
    margin-top: 20px;
    margin-right:50px;
    line-height: 80px;
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