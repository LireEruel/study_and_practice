<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
// 1. data get
request.setCharacterEncoding("utf-8");
String userName = request.getParameter("username");
String userPwd = request.getParameter("userpwd");
String[] fruits = request.getParameterValues("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 테스트</title>
</head>
<body>
	<h1>파라미터 테스트 결과</h1>
	<p><% out.println(userName + "님(" + userPwd + ")"+ "이 좋아하는 과일은" + Arrays.toString(fruits)); %> </p>
	<p><%= userName %>(<%=userPwd %>) 님이 좋아하는 과일은 <%= Arrays.toString(fruits) %>  </p>
</body>
</html>