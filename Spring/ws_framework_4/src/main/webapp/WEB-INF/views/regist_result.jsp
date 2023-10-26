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
<h1>도서 등록 결과</h1>

<c:if test="${!empty book}">
    <table>
        <thead>
        <tr>
            <th>항목</th>
            <th>내용</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>도서번호</td>
            <td>${book.isbn}</td>
        </tr>
        <tr>
            <td>도서명</td>
            <td>${book.title}</td>
        </tr>
        <tr>
            <td>저자</td>
            <td>${book.author}</td>
        </tr>
        <tr>
            <td>가격</td>
            <td>${book.price}</td>
        </tr>
        <tr>
            <td>이미지</td>
            <td>${book.img}</td>
        </tr>
        <tr>
            <td>설명</td>
            <td>${book.content}</td>
        </tr>
        </tbody>
    </table>
</c:if>

<c:if test="${empty book}">
    <p>등록된 정보가 없습니다.</p>
</c:if>

<a href="${root}/index">[홈으로]</a>
<a href="${root}/list">[도서목록]</a>
<c:if test="${!empty user}">
    <a href="${root}/regist">[추가등록]</a>
</c:if>

</body>
</html>