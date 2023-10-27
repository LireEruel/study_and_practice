package com.ssafy.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.test.model.ProductDto;
import com.ssafy.test.model.service.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;	
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String getRegist() {
		return "regist";
	}
	
	@GetMapping("/list")
	public String getList(Model model) throws Exception {
		List<ProductDto> list = productService.list();
		
		model.addAttribute("list", list);
		System.out.println(list.size());
		
		return "list";
	}
	
	@PostMapping("/regist")
	public String regist(ProductDto productDto) throws Exception {
		productService.regist(productDto);
		return "redirect:/list";
	}

}
