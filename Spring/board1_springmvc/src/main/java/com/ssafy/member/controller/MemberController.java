package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(MemberDto memberDto) throws Exception {
		logger.debug("join memberDto : {}", memberDto);
		memberService.joinMember(memberDto);
		return "redirect:/user/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userid") String userId, 
			@RequestParam("userpwd") String userPwd, HttpSession session) throws Exception {
		MemberDto memberDto = memberService.loginMember(userId, userPwd);
		if(memberDto != null) {
			session.setAttribute("userinfo", memberDto);
			return "redirect:/";
		}
		return "user/login";
	}
	
}
