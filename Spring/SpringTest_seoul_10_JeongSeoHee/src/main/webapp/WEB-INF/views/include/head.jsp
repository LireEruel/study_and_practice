<%@ page import="com.ssafy.test.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%
	MemberDto memberDto = (MemberDto) session.getAttribute("info");
	Cookie[] cookies = request.getCookies();
	String saveId = null;
	for (Cookie c : cookies) {
		if (c.getName().equals("saveId")) {
			saveId = c.getValue();
		}
	}
%>
<meta charset="UTF-8">
<title>상품 관리 사이트</title>
<%-- 부트스트랩 사용을 위한 코드 --%>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
	<%
		if (memberDto == null) {
	%>
		<%
			if (saveId == null) {
		%>
			<form action="${root}/member/login" method="post">
				<input type="text" name="id" placeholder="아이디"> 
				<input type="password" name="password" placeholder="비밀번호">
				<button type="submit">로그인</button>
				<input type="checkbox" name="saveId">아이디 저장
			</form>
	<%
		} else {
	%>
			<form action="${root}/member/login" method="post">
				<input type="text" name="id" placeholder="아이디" value=<%=saveId%>>
				<input type="password" name="password" placeholder="비밀번호">
				<button type="submit">로그인</button>
				<input type="checkbox" name="saveId" checked>아이디 저장
			</form>
		<%
			}
		%>
	<%
		} else {
	%>
		<%=memberDto.getName()%>
		님 안녕하세요.
		<a href="${root}/member/logout">로그아웃</a>
	<%
		}
	%>
<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>
<script>
	<c:if test="${!empty msg}">
		alert("${msg}");
	</c:if>
</script>