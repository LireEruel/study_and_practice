package com.ssafy.ws.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.ws.dto.User;

@Controller
public class UserController {
	
	@PostMapping("/login")
	public String doLogin(User user, HttpSession session, Model model) {
		String location = "/index";
		if(user.getId().equals("ssafy") && user.getPass().equals("1234")) {
			user.setName("김싸피");
			session.setAttribute("loginUser",user );
			location = "redirect:/";
		}
		else {
			model.addAttribute("msg", "로그인 실패");
		}
		return location;
	}
	
	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
