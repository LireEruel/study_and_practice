<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<head>
	<img src="resources/img/ssafy_logo.png" width="150">
    <h1 style="text-align: center">도서 관리</h1>

    <c:if test="${empty user}">
        <div style="text-align: end">
            <form method="post" action="./login">
                <input type="text" name="id">
                <input type="pass" name="pass">
                <input type="submit" value="로그인">
            </form>
        </div>
    </c:if>

    <c:if test="${!empty user}">
        <div style="text-align: end">
            <span><strong>${user.name}님 반갑습니다.</strong></span>
            <a href="${root}/logout">로그아웃</a>
        </div>
    </c:if>

    <hr>
</head>