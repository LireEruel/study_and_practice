package com.ssafy.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.test.exception.LoginFailedException;
import com.ssafy.test.model.MemberDto;
import com.ssafy.test.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	/**
	 * 로그인
	 * @param memberDto
	 * @param session
	 * @param request
	 * @param response
	 * @param saveId
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public String login(MemberDto memberDto, HttpSession session, HttpServletRequest request, HttpServletResponse response, boolean saveId) throws Exception {
		System.out.println(memberDto);
		MemberDto result = memberService.login(memberDto);
		
		if (result != null) {
			// 세션 등록
			session.setAttribute("info", result);
		}
		return "redirect:/index";
	}
	/**
	 * 로그아웃
	 * @param session
	 * @param response
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		// 세션 삭제
		session.removeAttribute("info");
		return "redirect:/index";
	}
}
