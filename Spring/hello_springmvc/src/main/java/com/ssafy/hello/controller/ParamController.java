package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {
	@GetMapping("/single")
	
	@PostMapping("/single")
	public String single(String userid, String username, int area) {
		return "single";
	}
	
	@GetMapping("/multi")
	public String multi() {
		return "multi";
	}
}
