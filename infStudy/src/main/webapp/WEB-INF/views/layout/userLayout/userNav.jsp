<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="breadcrumb">
	<a href="${bigTitle.path }">${bigTitle.title }</a> 
		<c:if test="${not empty smTitle }">
		/ <a href="${smTitle.path }">${smTitle.title }</a>
		</c:if>
	</ul>
</nav>