<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>footer</title>
<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
   src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="resources/common/css/signUp.css" rel="stylesheet">

<script>

   //////////////////////////////////////////////
   var emailCheck = 0;
    var nickCheck = 0;
    var pwdCheck = 0;
    //아이디 체크하여 가입버튼 비활성화, 중복확인.
    function emailChk() {
        var inputed = $('.email').val();
        console.log(inputed);
        $.ajax({
            data : {
                email : inputed
            },
            url : "emailChk",
            success : function(data) {
                if(inputed=="" && data=='0') {                  
                    $(".submitBtn").prop("disabled", true);
                    $(".submitBtn").css("background-color", "#aaaaaa");
                    $("#email").css("background-color", "#FFCECE");
                    emailCheck = 0;
                } else if (data == '0') {
                   $("#email_chk").text(""); 
                    $("#email").css("background-color", "#B0F6AC");
                    $(".submitBtn").prop("disabled", true);
                    $(".submitBtn").css("background-color", "#aaaaaa");
                    emailCheck = 1;
                    if(emailCheck==1 && pwdCheck == 1 && nickCheck) {
                        $(".submitBtn").prop("disabled", false);
                        $(".submitBtn").css("background-color", "#00c171");
                    } 
                } else if (data == '1') {
                    $("#email_chk").text("사용중인 이메일입니다.");
                    $("#email_chk").css("color","red");
                    $(".submitBtn").prop("disabled", true);
                    $(".submitBtn").css("background-color", "#aaaaaa");
                    $("#email").css("background-color", "#FFCECE");
                    emailCheck = 0;
                } 
            }
        });
    }
  //재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
    function pwdChk() {
        var inputed = $('.pass').val();
        var reinputed = $('#passwordChk').val();
        console.log(inputed);
        console.log(reinputed);
        if(reinputed=="" && (inputed != reinputed || inputed == reinputed)){
            $(".submitBtn").prop("disabled", true);
            $(".submitBtn").css("background-color", "#aaaaaa");
            $("#passwordChk").css("background-color", "#FFCECE");
        }
        else if (inputed == reinputed) {
           $(".submitBtn").prop("disabled", true);
            $(".submitBtn").css("background-color", "#aaaaaa");
            $("#passwordChk").css("background-color", "#B0F6AC");
            pwdCheck = 1;
            if(emailCheck==1 && pwdCheck == 1 && nickCheck==1) {
                $(".submitBtn").prop("disabled", false);
                $(".submitBtn").css("background-color", "#00c171");
            }
        } else if (inputed != reinputed) {
           pwdCheck = 0;
            $(".submitBtn").prop("disabled", true);
            $(".submitBtn").css("background-color", "#aaaaaa");
            $("#passwordChk").css("background-color", "#FFCECE");
            
        }
    }
    //닉네임과 이메일 입력하지 않았을 경우 가입버튼 비활성화
    function nickChk() {
        var nickname = $("#nickname").val();
        console.log(nickname);
        $.ajax({
            data : {
               nickname : nickname
            },
            url : "nickChk",
            success : function(data) {
                if(nickname=="" && data=='0') {
                    $(".submitBtn").prop("disabled", true);
                    $(".submitBtn").css("background-color", "#aaaaaa");
                    $("#nickname").css("background-color", "#FFCECE");
                    nickCheck = 0;
                } else if (data == '0') {
                   $("#nic_chk").text("");
                    $(".submitBtn").prop("disabled", true);
                    $(".submitBtn").css("background-color", "#aaaaaa");
                    $("#nickname").css("background-color", "#B0F6AC");
                    nickCheck = 1;
                    if(nickCheck ==1 && pwdCheck == 1 && emailCheck==1) {
                        $(".submitBtn").prop("disabled", false);
                        $(".submitBtn").css("background-color", "#00c171");
                    } 
                } else if (data == '1') {
                   $("#nic_chk").text("사용중인 닉네임입니다.");
                    $("#nic_chk").css("color","red");
                    $(".submitBtn").prop("disabled", true);
                    $(".submitBtn").css("background-color", "#aaaaaa");
                    $("#nickname").css("background-color", "#FFCECE");
                    nickCheck = 0;
                } 
            }
        });
    }

</script>
</head>
<script src="resources/common/js/ckeditor.js"></script>
<body>
   <div class="loginForm">
      <h1>회원가입</h1>
      <form:form  name="signup" method="post" action="signupCheck" modelAttribute="regUserVO">
         <div class="form-group">
            <form:label path="email">이메일 주소</form:label>
            <form:input  type="email" path="email" id="email" class="form-control email" oninput="emailChk()"
               placeholder="이메일"/>
               <div class="check_font" id="email_chk"></div>
<%--             <form:button  class="btn btn-default" onclick="validateEmail">중복확인</form:button> 
            <form:errors path="email" style="color:red" />   --%>
         </div>
         <div class="form-group">
            <form:label path="password">비밀번호</form:label>
            <form:password path="password" id="password" class="form-control pass"
               oninput="pwdChk()" placeholder="비밀번호"  />
            <%-- <form:errors path="password" style="color:red" /> --%>

         </div>
         <div class="form-group">
            <label path="passwordChk">비밀번호 확인</label> <input type="password"
               oninput="pwdChk()" class="form-control pass" id="passwordChk" placeholder="비밀번호" />
            <%-- <form:errors path="passwordChk" style="color:red"/> --%>
         </div>
         <div class="form-group">
            <%-- <form:hidden path="emailExist"/> --%>
            <form:label path="nickname">닉네임</form:label>
            <form:input type="text" path="nickname" class="form-control nickname" id="nickname" oninput="nickChk()" placeholder="닉네임" />
            <div class="check_font" id="nic_chk"></div>
         </div>
         <form:button type="submit" class="btn btn-default submitBtn" disabled="disabled" id="joinBtn">가입하기</form:button>
      </form:form>
   </div>
</body>
</html>