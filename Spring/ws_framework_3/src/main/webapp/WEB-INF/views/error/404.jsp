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
	<h1>요청하신 파일은 존재하지 않습니다.</h1>
	<a href="${root}/index">[홈으로]</a>
</body>
</html>