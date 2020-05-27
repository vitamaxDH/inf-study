<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="root">
	<div class="container">
		<header class="header">
			<h1>강의 커리큘럼 등록 페이지</h1>
		</header>
		<section class="contents">
			<form:form id="myForm" modelAttribute="addCurriculumVO">
			
				<div class="section-form">
					<form:label path="section"><span>섹션</span></form:label> <br />
					<form:select path="section" id="section">
						<c:forEach var="list" items="${sectionList }" varStatus="status">
							<form:option value="${list }"></form:option>
						</c:forEach>
							<form:option value="직접입력" id="directInput">직접입력</form:option> 
					</form:select>
					<input type="text" disabled="true" id="inputSection"/>
				</div>
			
				<div class="title-form">
					<form:label path="title"><span>커리큘럼 제목</span></form:label><br />
					<form:input path="title" id="title"/>
				</div>
				
				<div class="url-form">
					<form:label path="url"><span>커리큘럼 url</span></form:label><br />
					<form:input path="url" id="url"/>
				</div>
				
				<div class="playtime-form">
					<form:label path="playtime"><span>재생시간</span></form:label><br />
					<form:input path="playtime" id="playtime"/>
				</div>
				<div class="buttons">
					<button id="submitBtn">등록</button>
					<button type="reset" id="resetBtn">다시쓰기</button>
					<button id="goBackBtn">뒤로가기</button>
				</div>
			</form:form>
		</section>
	</div>
</div>
</body>

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
			}else{
	
				inputStatus = false;
				console.log(inputStatus);
				inputSection.setAttribute("disabled", true);
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
				submit.setAttribute("action", "/course/${lecture_title}/addCurriculum");
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


<link href="${root }/resources/common/css/courseCss/addCurriculumPg.css" rel="stylesheet">	
</html>






