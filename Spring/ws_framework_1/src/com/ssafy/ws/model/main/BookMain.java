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

public class BookMain {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/applicationConfig.xml");
		BookService bookService = (BookService) context.getBean("bookServiceImpl");

		Book bookDto = new Book();
		System.out.print("isbn : ");
		bookDto.setIsbn(in.readLine());
		System.out.print("제목 : ");
		bookDto.setTitle(in.readLine());
		System.out.print("작가 : ");
		bookDto.setAuthor(in.readLine());
		System.out.print("가격 : ");
		bookDto.setPrice(Integer.parseInt(in.readLine()));
		System.out.print("내용 : ");
		bookDto.setContent(in.readLine());
		bookDto.setImg("이미지주소");

		try {
			bookService.insert(bookDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("================================== 책목록 ================================== ");
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("pgno", "1");
			map.put("key", "");
			map.put("word", "");
			// List<BoardDto> list = boardController.listArticle(map);
			// for(BoardDto article : list) {
			// System.out.println(article);
			// }

			List<Book> list = bookService.search();
			for (Book book : list) {
				System.out.println(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
