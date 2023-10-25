package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView bookList() {
		ModelAndView mav = new ModelAndView();
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("111-222-3333", "홍길동", "책제목 1", 10000, "좋은 책 1", "abc1.png"));
		books.add(new Book("111-222-4444", "임꺽정", "책제목 2", 20000, "좋은 책 2", "abc2.png"));
		books.add(new Book("111-333-4444", "장길산", "책제목 3", 30000, "좋은 책 3", "abc3.png"));
		mav.addObject("books", books);
		return mav;
	}
	@GetMapping("/regist")
	public String registPage() {
		return "regist";
	};
	
	@PostMapping("/regist")
	public String regist(Book book, Model model) throws Exception {
		bookService.insert(book);
		model.addAttribute("book", book);
		return "regist_result";
	}
	
}
