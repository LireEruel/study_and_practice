package com.ssafy.hello.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/basic")
public class HelloController {

//	@RequestMapping("/hello1")
//	public String hello1() {
//		return "result/view";
//	}
	
//	@GetMapping("/hello1")
//	public String hello1(HttpServletRequest request) {
//		request.setAttribute("msg", "안녕하세요 스프링입니다.");
//		return "result/view";
//	}
	
//	@GetMapping("/hello1")
//	public String hello1(Model model) {
//		model.addAttribute("msg", "Hello Spring!!!");
//		return "result/view";
//	}
	
	@GetMapping("/hello1")
	public String hello1(Map model) {
		model.put("msg", "Hello2222 Spring!!!");
		return "result/view";
	}
	
	@GetMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "MAV 데이터입니다.");
		mav.setViewName("result/view");
		return mav;
	}
	

}
