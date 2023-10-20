package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.hello.model.MultiDto;

@Controller
@RequestMapping("/param")
public class ParamController {

	@GetMapping("/single")
	public String single() {
		return "single";
	}
	
	@PostMapping("/single")
	public String single(@RequestParam("userid") String userId, String username, @RequestParam(value = "area", required = false, defaultValue = "100") int area) {
		System.out.println(userId + "\t" + username + "\t" + area);
		return "single";
	}
	
	@GetMapping("/multi")
	public String multi() {
		return "multi";
	}
	
//	@PostMapping("/multi")
//	public String multi(MultiDto multiDto) {
//		System.out.println(multiDto);
//		return "result/view";
//	}
	
//	@PostMapping("/multi")
//	public String multi(MultiDto multiDto, Model model) {
//		System.out.println(multiDto);
//		model.addAttribute("info", multiDto);
//		return "result/view";
//	}
	
	@PostMapping("/multi")
	public String multi(@ModelAttribute("info") MultiDto multiDto) {
		System.out.println(multiDto);
		return "result/view";
	}
	
}
