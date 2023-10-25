package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.dto.Book;

public interface BookService {
	int insert(Book book) throws Exception;
	int update(Book book) throws Exception;
	int delete(String id) throws Exception;
	Book select(String id) throws Exception;
	List<Book> search() throws Exception;
}
