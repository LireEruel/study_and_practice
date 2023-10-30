<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<div class="container p-4">
		<h2>상품 상세 정보</h2>
		<table>
			<tr>
				<td>코드</td>
				<td>모델</td>
				<td>가격</td>
				<td>등록자</td>
			</tr>
			<tr>

				<td>${dto.code}</td>
				<td>${dto.model}</td>
				<td>${dto.price}</td>
				<td>${dto.id}</td>
			</tr>
		</table>
		<a href="${root}/product/delete/${code}">삭제하기</a> <a
			href="${root }/product/list">상품 목록</a>
	</div>
</body>
</html>