package com.ssafy.ws.model.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;

public class BookMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/applicationConfig.xml");
		BookService bs = context.getBean(BookServiceImpl.class);
		// UserService us = context.getBean(UserServiceImpl.class);

		List<Book> books = bs.search();
		Book book = bs.select(books.get(0).getIsbn());
		book.setContent("수정수정수정");
		System.out.println("update : " + bs.update(book));
		Book book2 = new Book("12", "1", "1", 11, "1", "1");
		System.out.println("insert : " + bs.insert(book2));
		System.out.println("delete : " + bs.delete("12"));

		// System.out.println(us.select("ssafy"));

	}
}
