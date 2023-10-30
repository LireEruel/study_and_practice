package com.ssafy.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.test.model.MemberDto;
import com.ssafy.test.model.ProductDto;
import com.ssafy.test.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;
	
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	/**
	 * 등록 페이지 이동
	 * @return
	 */
	@GetMapping("/regist")
	public String goRegist() {
		return "regist";
	}
	
	/**
	 * 상품 등록
	 * @param productDto
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/regist")
	public String regist(ProductDto productDto, HttpSession session) throws Exception{
		System.out.println(productDto);
		//상품 등록
		productService.regist(productDto);
		return "redirect:/product/list";
	}
	
	/**
	 * 상품 목록 조회
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/list")
	public String goList(Model model) throws Exception{
		List<ProductDto> list = productService.selectAll();
		model.addAttribute("list" , list);
		return "list";
	}
	
	/**
	 * 상품 삭제
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/delete/{code}") 
	public String delete(@PathVariable("code") String code) throws Exception{
		productService.deleteByCode(code);
		return "redirect:/product/list";
	}
	
	/**
	 * 상품 조회
	 * @param code
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/view/{code}")
	public String view(@PathVariable("code") String code, Model model) throws Exception{
		ProductDto product = productService.selectByCode(code);
		model.addAttribute("dto", product);
		return "detail";
	}
}
