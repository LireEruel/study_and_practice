<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/include/head.jsp"%>
    <style>
      th,
      td {
        border: 1px solid black;
      }
    </style>
  </head>
  <body>
    <%@ include file="/include/nav.jsp"%>

    <div class="container p-4">
      <h2>상품 정보</h2>
      <table>
        <tr>
          <td>코드</td>
          <td>${product.code}</td>
        </tr>
        <tr>
          <td>모델</td>
          <td>${product.model}</td>
        </tr>
        <tr>
          <td>가격</td>
          <td>${product.price}</td>
        </tr>
      </table>
      <%-- 로그인 되어 있을 때만 수정, 삭제 보이도록 함 --%>
      <c:if test="${!empty userinfo}">
        <a href="${root}/product?action=mvmodify&code=${product.code}">수정</a>
        <a href="${root}/product?action=delete&code=${product.code}">삭제</a>
      </c:if>
      <a href="${root}/product?action=list">목록</a>
    </div>

    <%@ include file="/include/footer.jsp"%>
  </body>
</html>
