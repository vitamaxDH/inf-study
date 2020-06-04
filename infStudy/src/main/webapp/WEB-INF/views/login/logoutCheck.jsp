<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}/"/>
<%
response.setHeader("'Cache-Control'","'no-store'");
response.setHeader("'Pragma'","'no-cache'");
response.setDateHeader("'Expires'",0);
if (request.getProtocol().equals("'HTTP/1.1'"))
        response.setHeader("'Cache-Control'", "'no-cache'");
%>
<script>
	alert("로그아웃되었습니다.!");
	location.href="${root}";
		
</script>