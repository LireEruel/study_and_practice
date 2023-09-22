<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
	import="com.ssafy.board.dao.BoardDaoImpl,com.ssafy.board.model.BoardDto,java.util.*"    
%>
<% 

//1. DB에서 글 목록을 Dao의 ListArticle()메소드를 이용하여 select하여 List로 얻어오세요.
List<BoardDto> list = BoardDaoImpl.getBoardDao().listArticle();
System.out.println(list);
request.setAttribute("articles", list);
RequestDispatcher disp = request.getRequestDispatcher("/board/list.jsp");
disp.forward(request, response);
%>