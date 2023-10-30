package com.ssafy.test.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ssafy.test.exception.LoginFailedException;

@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(LoginFailedException.class)
	public String catchLoginFailed(LoginFailedException e, Model model) {
		String message = e.getMessage();	//에러 메시지 뽑아오기
		model.addAttribute("msg", "Error : " + message);	//에러 메시지 등록
		return "error/error";	//에러 페이지로 이동
	}
	
	/**
	 * 페이지를 찾을 수 없을 떄 : 404
	 * @param e
	 * @return
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public String catchNoHandlerFound(NoHandlerFoundException e) {
		return "error/404";
	}
	
	/**
	 * 에러 처리
	 * @param e
	 * @param model
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public String catchException(Exception e, Model model) {
		String message = e.getMessage();	//에러 메시지 뽑아오기
		model.addAttribute("msg", "Error : " + message);	//에러 메시지 등록
		return "error/error";	//에러 페이지로 이동
	}
}
