<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/resources/common/css/bootstrap.min.css" rel="stylesheet">
<link href="${root}/resources/common/css/courseCss/playLecture.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
</head>

<body>
   
   <div class="container">
        <div class="nav">
            <div class="nav-head">
                <div class="nav-head-name">${lecture_title }</div>
                <p>진도율 : 00강 / ${fn:length(curriculum_list)}강 (00.00%) | 시간 : 000분 / 000분</p>
                <progress class="progress is-primary" value="00.00%" max="100" style=" width: 100%;">00.00%</progress>
            </div>
            <div class="nav-ul">
                <ul>
                   <c:forEach var="list" items="${curriculum_list }" varStatus="status">
                       <c:if test="${status.count == 1 }">
                        <li class="li-head">
                           ${curriculum_list[status.count-1].section } 
                        </li>
                        <c:choose>
                           <c:when test="${c_no eq list.c_no }" >
                           <li class="li-selected" onclick="gotoLec(${curriculum_list[status.count-1].c_no})">
                              ${curriculum_list[status.count-1].curriculum_title }
                              <c:set var="title" value="${curriculum_list[status.count-1].curriculum_title }"/>
                           </li>                           
                           </c:when>
                           
                           <c:otherwise>
                           <li class="li-content"  onclick="gotoLec(${curriculum_list[status.count-1].c_no})">
                                  ${curriculum_list[0].curriculum_title }
                           </li>
                           </c:otherwise>                                                
                        </c:choose>
                     </c:if>
                     
                     <c:if test="${status.count ne fn:length(curriculum_list)}">
                        <c:if test="${curriculum_list[status.count-1].section ne curriculum_list[status.count].section}">
                           <li class="li-head">
                              ${curriculum_list[status.count].section }
                           </li> 
                        </c:if>
                        <c:choose>
                           <c:when test="${c_no eq curriculum_list[status.count].c_no }">
                              <li class="li-selected"  onclick="gotoLec(${curriculum_list[status.count].c_no})">
                                     ${curriculum_list[status.count].curriculum_title }
                                  <c:set var="title" value="${curriculum_list[status.count].curriculum_title }"/>                                  
                              </li>                        
                           </c:when>
                           <c:otherwise>
                              <li class="li-content" onclick="gotoLec(${curriculum_list[status.count].c_no})">
                                     ${curriculum_list[status.count].curriculum_title }
                              </li>
                           </c:otherwise>                                                
                        </c:choose>
                     </c:if>
                   </c:forEach>
                </ul>
            </div>
        </div>
        <div class="content">
            <div class="content-head">
                <div class="content-head-title">${title }</div>
                <a href="#"><div class="content-head-exit out">X</div></a>
            </div>
            <div class="vedio">
                <iframe src="${url }" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        </div>
    </div>
               
               
<script>
var outBtn = document.querySelector(".out");

outBtn.addEventListener("click", function(){
    location.href = "${root}/course/${lecture_title}";
})

function gotoLec(c_no){
   location.href = "${root }/course/${lecture_title}/lecture/" + c_no;
}
</script>

</body>
</html>

