<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY 도서 관리</title>
</head>
<body>
    <!-- 헤더 -->
    <%@ include file="include/header.jsp" %>
    
    <h1>도서 등록 </h1>
    <form method="post" action="./regist">
        <fieldset>
            <legend>도서 등록 정보</legend>
            <label for="isbn">도서번호</label>
            <input type="text" name="isbn" id="isbn"><br>
            <label for="title">도서명</label>
            <input type="text" name="title" id="title"><br>
            <label for="author">저자</label>
            <input type="text" name="author" id="author"><br>
            <label for="price">가격</label>
            <input type="number" name="price" id="price"><br>
            <label for="img">이미지</label>
            <input type="text" name="img" id="img"><br>            
            <label for="content">설명</label>
            <textarea name="content" id="content"></textarea><br>
            <input type="submit" value="등록">
            <input type="reset" value="초기화">
        </fieldset>
    </form>
    
    <a href="${root}/index">[홈으로]</a>
</body>
</html>