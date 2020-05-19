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

<form:form action="${root }/course/addLecture" method="post" modelAttribute="addLecture" enctype="multipart/form-data">
	<form:hidden path="i_no" value="${login.u_no }"/>
	<form:label path="ctg_no">카테고리</form:label>
	<form:select path="ctg_no">
		<c:forEach var="category" items="${categoryList }">
			<form:option value="${category.ctg_no }">${category.name }</form:option>
		</c:forEach>
	</form:select> <br />
	<form:label path="title">강의 제목</form:label>
	<form:input path="title"/> <br />
	<form:label path="price">가격</form:label>
	<form:input path="price"/> <br />
	<form:label path="difficulty">난이도</form:label>
	<form:input path="difficulty"/> <br />
	<form:input type="file" path="lectureImg" accept="image/*"/> <br />
	<form:button>등록하기</form:button>
</form:form>


</body>
</html>