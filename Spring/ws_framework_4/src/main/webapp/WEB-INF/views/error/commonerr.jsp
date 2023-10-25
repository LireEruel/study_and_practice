<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="../include/header.jsp"%>
	<c:if test="${empty errmsg}">
		<h1>서버 에러입니다.</h1>
	</c:if>	
	<c:if test="${!empty errmsg}">
		<h1>${errmsg}</h1>
	</c:if>
	<a href="${root}/index">[홈으로]</a>
</body>
</html>