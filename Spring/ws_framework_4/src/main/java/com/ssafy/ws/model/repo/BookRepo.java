package com.ssafy.ws.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Book;

public interface BookRepo {
	int insert (Book book) throws Exception;
	int update (Book book) throws Exception;
	int delete(String id) throws Exception;
	Book select(String id) throws Exception;
	List<Book> search() throws Exception;
}
