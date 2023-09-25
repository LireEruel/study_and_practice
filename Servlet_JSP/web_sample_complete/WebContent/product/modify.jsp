<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 로그인 되어 있을 때 --%>
	<c:if test="${!empty userinfo}">
        <c:if test="${!empty product}">
            <div class="container p-4">
              <h2>상품 정보 수정</h2>
              <form id="modifyForm" method="post" action="">
                  <input type="hidden" name="action" value="modify">
                <div class="form-group">
                  <label for="productCode">고유번호</label>
                  <input type="text" class="form-control" id="productCode" name="code" value="${product.code}">
                </div>
                <div class="form-group">
                  <label for="model">모델명</label>
                  <input type="text" class="form-control" id="model" name="model" value="${product.model}">
                </div>
                <div class="form-group">
                  <label for="price">가격</label>
                  <input type="number" class="form-control" id="price" name="price" value="${product.price}">
                </div>
        
                <button type="submit" class="btn btn-primary" id="btn-modify">수정</button>
                <a class="btn btn-secondary" href="#" >취소</a>
              </form>
            </div>

            <script>
                document.querySelector("#btn-modify").addEventListener("click", function () {
                  if (!document.querySelector("#productCode").value) {
                    alert("코드를 입력하세요.");
                    return;
                  } else if (!document.querySelector("#model").value) {
                    alert("모델명을 입력하세요.");
                    return;
                  } else if (!document.querySelector("#price").value) {
                    alert("가격을 입력하세요.");
                    return;
                  } else {
                    let form = document.querySelector("#modifyForm");
                    form.setAttribute("action", "${root}/product");
                    form.submit();
                  }
                });
              </script>
        </c:if>
        
        <%-- 잘못된 경로로 접근해 삼품이 없는 경우 --%>
        <c:if test="${empty product}">
            <script>
                alert("잘못된 접근입니다.");
                location.href = "${root}/index.jsp";
            </script>
        </c:if>
	</c:if>

	<%-- 로그인되어 있지 않은 경우 --%>
	<c:if test="${empty userinfo}">
		<script>
			alert("로그인 하세요.");
			location.href = "${root}/index.jsp";
		</script>
	</c:if>
	
<%@ include file="/include/footer.jsp" %>