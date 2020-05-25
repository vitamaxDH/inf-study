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
</head>
<body>
	
	<main id="main">
		<section class="lecture_container">
			<aside class="lecture_nav">
				<div class="lecture_nav_header">
					<h5>${lecture_title }</h5>
					<p>
						<span class="is-bold">기간 : </span> "무제한"
					</p>
					<div class="progress_container">
						<div class="inff_progress">
							<label for="">진도율 : O강 / ${fn:length(curriculum_list)}강 (OO.OO%) | 시간 : OO분 / OOO분</label>
							<progress class="progress is-primary" value="OO.OO%" max="100">OO.OO%</progress>
						</div>
					</div>
				</div>
				<div class="curriculum">
					<ul>
						<c:forEach var="list" items="${curriculum_list }" varStatus="status">
																
							<c:if test="${status.count == 1 }">
								<li class="list unit unit_section">
									<span class="unit_title">${curriculum_list[status.count-1].section }</span> 
								</li>
								<c:choose>
									<c:when test="${c_no eq list.c_no }" >
									<li class="list unit unit_lecture is_opened"   onclick="gotoLec(${curriculum_list[status.count-1].c_no})">
									 		<span class="unit_title">${curriculum_list[status.count-1].curriculum_title }</span>
									 		<span class="unit_checked icon"></span>
									 		<c:set var="title" value="${curriculum_list[status.count-1].curriculum_title }"/>
									</li>									
									</c:when>
									
									<c:otherwise>
									<li class="list unit unit_lecture"  onclick="gotoLec(${curriculum_list[status.count-1].c_no})">
									 		<span class="unit_title">${curriculum_list[0].curriculum_title }</span>
									 		<span class="unit_checked icon"></span>
									</li>
									</c:otherwise>																
								</c:choose>
							</c:if>
							
							<c:if test="${status.count ne fn:length(curriculum_list)}">
								<c:if test="${curriculum_list[status.count-1].section ne curriculum_list[status.count].section}">
									<li class="list unit unit_section">
										<span class="unit_title">${curriculum_list[status.count].section }</span>
									</li> 
								</c:if>
								<c:choose>
									<c:when test="${c_no eq curriculum_list[status.count].c_no }">
										<li class="list unit unit_lecture is_opened"  onclick="gotoLec(${curriculum_list[status.count].c_no})">
												 <span class="unit_title">${curriculum_list[status.count].curriculum_title }</span>
												 <span class="unit_checked icon"></span>
									 		<c:set var="title" value="${curriculum_list[status.count].curriculum_title }"/>											 
										</li>								
									</c:when>
									<c:otherwise>
										<li class="list unit unit_lecture" onclick="gotoLec(${curriculum_list[status.count].c_no})">
												 <span class="unit_title">${curriculum_list[status.count].curriculum_title }</span>
												 <span class="unit_checked icon"></span>
										</li>
									</c:otherwise>																
								</c:choose>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</aside>
			
			<div class="content_container center">
				<header class="content_header_nav">
					<div class="toggle_left">
						<div class="unit_title">
							<h1>${title }</h1>
							<div class="out">나가기</div>
						</div>
					</div>
				</header>
				<div class="content unit_body">
					<div class="player_cover">
						<div class="not_container">
							<div class="iframe_container">
								<iframe width="800" height="600" src="https://www.youtube.com/embed/PoJ8chlMBJI" 
										frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
								</iframe>		
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>


<script>
var outBtn = document.querySelector(".out");

outBtn.addEventListener("click", function(){
    location.href = "${root}/course/${lecture_title}";
})

function gotoLec(c_no){
	location.href = "${root }/course/${lecture_title}/lecture/" + c_no;
}
</script>

	
<link href="${root }/resources/common/css/courseCss/playLecture.css" rel="stylesheet">
</body>
</html>