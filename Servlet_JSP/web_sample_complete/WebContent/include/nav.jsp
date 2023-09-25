<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/product?action=list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/product/regist.jsp">상품 정보 등록</a></li>
	</ul>

	<%-- 로그인 한 경우 --%>
	<c:if test="${not empty userinfo}">
      <div style="text-align: center">
        <span style="color: gray;"><strong>${userinfo.name}</strong> (${userinfo.id})님 안녕하세요.</span>
        <a href="${root}/user?action=logout">로그아웃</a>
      </div>
    </c:if>

	<%-- 로그인 안 한 경우 --%>
    <c:if test="${empty userinfo}">
      <div style="text-align: center">
		<form id="form-login" method="post" action="">
			<input type="hidden" name="action" value="login">
			<input type="text" id="login-id" name="login-id" placeholder="아이디"/>
			<input type="password" id="login-pwd" name="login-pwd" placeholder="비밀번호"/>
			<button type="button" id="btn-login">로그인</button>
		</form>
      </div>
      
      <script>
		document.querySelector("#btn-login").addEventListener("click", function() {
			if (!document.querySelector("#login-id").value) {
				alert("아이디를 입력하세요.");
				return;
			} else if (!document.querySelector("#login-pwd").value) {
				alert("비밀번호를 입력하세요.");
				return;
			} else {
				let form = document.querySelector("#form-login");
				form.setAttribute("action", "${root}/user");
				form.submit();
			}
		});
	</script>
    </c:if>
</nav>