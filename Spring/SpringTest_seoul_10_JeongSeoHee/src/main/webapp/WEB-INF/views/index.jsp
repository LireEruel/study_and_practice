<%@ page import="com.ssafy.test.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDto memberDto = (MemberDto) session.getAttribute("info");
%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

a {
	margin: 10px;
}

.inputtitle {
	display: inline-block;
	width: 80px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1>출결 관리</h1>
	<% if(memberDto == null) { %>
	
		<fieldset>
			<h1>로그인 해주세요.</h1>
			<form action="${root}/member/login" method="post">
				<label for="id" class="inputtitle">아이디</label>
				<input type="text" name="id" id="id" placeholder="아이디"> 
				<br>
				<label for="pw" class="inputtitle">비밀번호</label>
				<input id="password" type="password" name="pw" placeholder="비밀번호">
				<br>
				<button type="submit">로그인</button>
			</form>
		</fieldset>
	<hr>
	<% } %>
	<h4>
		<a href="${root}/product/regist">출결 이슈 등록</a>
	</h4>
	<h4>
		<a href="${root}/product/list">출결 이슈 목록</a>
	</h4>

</body>
</html>