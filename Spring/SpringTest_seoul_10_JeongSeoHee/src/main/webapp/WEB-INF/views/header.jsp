<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%@ page import="com.ssafy.test.model.MemberDto"%>

<style>
	#loginInfo{
		text-align: right;
	}
	#head{
		text-align: center;
	}
	
	.inputtitle{
		display: inline-block;
		width: 100px;
		background: silver;
		text-align: center;
	}
</style>
	
	<c:if test="${!empty info}">
		<div id="loginInfo">
			${info.name}(${info.position})님 로그인되었습니다. <a href="${root}/member/logout ">로그아웃</a>
		</div>
	</c:if>

<h1 id="head">${title }</h1>
<hr>
