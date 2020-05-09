<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form role="form" method="POST" modelAttribute="testCkVO"
		action="${pageContext.request.contextPath}/testSave">
		<form:input path="title" />
		<form:input path="content" />
		<input type="submit" value="실험!">
	</form:form>
</body>
</html>