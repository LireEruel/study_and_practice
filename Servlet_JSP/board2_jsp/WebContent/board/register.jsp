<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.board.model.BoardDto, com.ssafy.board.dao.BoardDaoImpl" %>
<%
request.setCharacterEncoding("utf-8");

BoardDto boardDto = new BoardDto();
boardDto.setUserId(request.getParameter("userid"));
boardDto.setSubject(request.getParameter("subject"));
boardDto.setContent(request.getParameter("content"));

int cnt = BoardDaoImpl.getBoardDao().writeArticle(boardDto);
System.out.println(cnt);
if(cnt != 0) {
	response.sendRedirect("result_success.jsp");
}else {
	response.sendRedirect("result_fail.jsp");
}

%>

