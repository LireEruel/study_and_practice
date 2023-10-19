package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.ssafy.util.DBUtil;
import com.ssafy.ws.model.dto.Book;

public class BookRepoImpl implements BookRepo {
	
	private DataSource dataSource;
	private DBUtil dbUtil;
	
	

	public BookRepoImpl(DataSource dataSource, DBUtil dbUtil) {
		super();
		this.dataSource = dataSource;
		this.dbUtil = dbUtil;
	}

	@Override
	public int insert(Book book) throws SQLException {
		System.out.println("BookRepo insert method call!!!!!");
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board (isbn, title, author, price, content, img) \n");
			sql.append("values (?, ?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getContent());
			pstmt.setString(6, book.getImg());
			cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> search() {
		// TODO Auto-generated method stub
		return null;
	}

}
