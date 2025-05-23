<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
</head>
<body>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark>파라미터 테스트!!!</mark>
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-param" method="POST" action="">
            <div class="mb-3">
              <label for="username" class="form-label">이름 : </label>
              <input
                type="text"
                class="form-control"
                id="username"
                name="username"
                placeholder="이름..."
              />
            </div>
            <div class="mb-3">
              <label for="userpwd" class="form-label">비밀번호 : </label>
              <input
                type="password"
                class="form-control"
                id="userpwd"
                name="userpwd"
                placeholder="비밀번호..."
              />
            </div>
            <div class="mb-3">좋아하는 과일?</div>
            <div class="form-check">
		      <input type="checkbox" class="form-check-input" name="fruit" value="사과">
		      <label class="form-check-label">사과</label>
		     </div>
		     <div class="form-check">
		      <input type="checkbox" class="form-check-input" name="fruit" value="딸기">
		      <label class="form-check-label">딸기</label>
		     </div>
		     <div class="form-check mb-3">
		      <input type="checkbox" class="form-check-input" name="fruit" value="수박">
		      <label class="form-check-label">수박</label>
		    </div>
            <div class="col-auto text-center">
              <button type="button" id="btn-send" class="btn btn-outline-primary mb-3">
                전송
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script>
      document.querySelector("#btn-send").addEventListener("click", function () {
        if (!document.querySelector("#username").value) {
          alert("이름 입력!!");
          return;
        } else if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-param");
          form.setAttribute("action", "/board1_servlet/ptest/param.jsp");
          form.submit();
        }
      });
    </script>
  </body>
</html>