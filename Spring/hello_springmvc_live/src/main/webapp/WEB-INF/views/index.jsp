<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Spring MVC !!!</h1>
	<a href="${root}/basic/hello1">Hello1 Spring</a><br>
	<a href="${root}/basic/hello2">Hello2 Spring</a><br>
	<a href="${root}/param/single">single parameter test</a><br>
	<a href="${root}/param/multi">multi parameter test</a><br>
</body>
</html>