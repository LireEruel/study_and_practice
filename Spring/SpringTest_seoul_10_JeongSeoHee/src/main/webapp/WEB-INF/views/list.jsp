<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: gray;
}

th, td {
	border: 1px dotted black;
	text-align: center;
}

#selectedDel {
	text-align: right;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<form method="" action="">
		<table>
			<tr>
				<th>이슈번호</th>
				<th>학번</th>
				<th>교육생명</th>
				<th>반</th>
				<th>지역</th>
				<th>날짜</th>
				<th>사유</th>
				<th>삭제</th>
			</tr>
			<c:if test="${empty info.usernumber}">
				<c:forEach items="${list}" var="dto">
					<tr>
						<td><a href="${root}/product/view/${dto.ano}">${dto.ano}</a></td>
						<td>${dto.usernumber}</td>
						<td></td>
						<td></td>
						<td></td>
						<td>${dto.issuedate}</td>
						<td>${dto.issue}</td>
						<td><a href="${root}/product/delete/${dto.ano}">삭제하기</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${!empty info.usernumber}">
				<c:forEach items="${list}" var="dto">
					<c:if test="${dto.usernumber eq info.usernumber}">
					<tr>
						<td><a href="${root}/product/view/${dto.ano}">${dto.ano}</a></td>
						<td>${dto.usernumber}</td>
						<td>${info.name}</td>
						<td>${info.rclass}</td>
						<td>${info.rname}</td>
						<td>${dto.issuedate}</td>
						<td>${dto.issue}</td>
						<td><a href="${root}/product/delete/${dto.ano}">삭제하기</a></td>
					</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</table>
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>