<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY 도서 관리</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<!-- 헤더 -->
<%@ include file="include/header.jsp" %>
<h1>도서 목록</h1>

<c:if test="${!empty books}">
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>ISBN</th>
                <th>제목</th>
                <th>저자</th>
                <th>가격</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr id="tr${status.index + 1}">
                    <td>${status.index}</td>
                    <td id="tr${status.index}td">${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty books}">
    <p>등록된 정보가 없습니다.</p>
</c:if>

<a href="${root}/">[홈으로]</a>
<c:if test="${!empty user}">
    <a href="${root}/regist">[추가등록]</a>
</c:if>

</body>
</html>