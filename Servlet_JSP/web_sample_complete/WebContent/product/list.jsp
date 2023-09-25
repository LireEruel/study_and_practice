<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/include/head.jsp"%>
    <style>
      tbody tr {
        cursor: pointer;
      }
      th,
      td {
        border: 1px solid black;
      }
    </style>
  </head>
  <body>
    <%@ include file="/include/nav.jsp"%> <%-- 페이지만의 내용 --%>

    <div class="container p-4">
      <h2>상품 목록</h2>
      <c:if test="${!empty pcount}">
        <p>등록된 상품 수 : ${pcount}</p>
      </c:if>
      <table>
        <thead>
          <tr>
            <th>코드</th>
            <th>모델</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
       	<%-- 상품 목록을 한줄씨 출력함 --%>
          <c:forEach var="product" items="${products}" varStatus="status">
            <tr id="tr${status.index}">
              <td id="tr${status.index}td">${product.code}</td>
              <td>${product.model}</td>
              <td>${product.price}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <%-- 로그인 되어 있는 상태라면 추가 상품 등록 버튼 보이게 함 --%>
      <c:if test="${!empty userinfo}">
        <a href="${root}/product?action=mvregist">추가 등록</a>
      </c:if>
    </div>

	<%-- 테이블 한 열을 클릭하면 해당 상품 페이지로 이동 --%>
    <script>
      document.querySelectorAll("tbody tr").forEach((tr) => {
        let id = "#" + tr.id + "td";
        console.log(id);
        tr.addEventListener("click", function () {
          let code = document.querySelector(id).textContent;
          location.href = "${root}/product?action=view&code=" + code;
        });
      });
    </script>

    <%@ include file="/include/footer.jsp"%>
  </body>
</html>
