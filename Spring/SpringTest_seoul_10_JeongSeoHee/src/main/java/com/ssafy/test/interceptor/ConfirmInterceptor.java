package com.ssafy.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mysql.cj.Session;
import com.ssafy.test.model.MemberDto;

public class ConfirmInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		//session에서 로그인 확인
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("info");
		if(memberDto == null) {	//로그인 되어있지 않으면
			throw new Exception("로그인 먼저 하세요^^");	//냅다 에러 던지기
			
			//index 페이지로 이동해도 됨
			//response.sendRedirect(request.getContextPath() + "/index");
			//return false;
		}
		return true;
	}
}
