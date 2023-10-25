package com.ssafy.ws;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.ws.config.ApplicationConfig;
import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;
import com.ssafy.ws.model.service.UserServiceImpl;

public class ws_01_BeanCreationTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		BookService bs = context.getBean(BookServiceImpl.class);
		UserService us = context.getBean(UserServiceImpl.class);

		List<Book> books = bs.search();
		Book book = bs.select(books.get(0).getIsbn());
		book.setContent("수정수정수정");
		System.out.println("update : " + bs.update(book));
		Book book2 = new Book("12", "1", "1", 11, "1", "1");
		System.out.println("insert : " + bs.insert(book2));
		System.out.println("delete : " + bs.delete("12"));

		System.out.println(us.select("ssafy"));

	}
}
