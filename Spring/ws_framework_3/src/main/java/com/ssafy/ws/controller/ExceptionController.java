package com.ssafy.ws.controller;

import java.net.BindException;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = Exception.class)
	public String handleException(Model model, Exception e){
		if(e instanceof BindException) {
			model.addAttribute("errmsg", "파라미터가 잘 전달되었는지 확인 필요");
		}
		return "/error/commonerr";
	}
}
