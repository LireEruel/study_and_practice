package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.util.DBUtil;
import com.ssafy.ws.model.dto.Book;

@Repository
public class BookRepoImpl implements BookRepo {

	private DataSource dataSource;
	private DBUtil dbUtil;

	@Autowired
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
			sql.append("insert into book (isbn, title, author, price, content, img) \n");
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
	public int update(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update book \n");
			sql.append("set title = ").append(book.getTitle());
			sql.append(", set author = ").append(book.getAuthor());
			sql.append(", set price = ").append(book.getPrice());
			sql.append(", set content = ").append(book.getContent());
			sql.append(",set img = ").append(book.getImg()).append("\n");
			sql.append("where isbn = ").append(book.getIsbn());
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.executeQuery();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return 0;
	}

	@Override
	public int delete(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from book \n");
			sql.append("where isbn = ").append(id);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.executeQuery();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return 0;
	}

	@Override
	public Book select(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book result = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"select * from book \n");
			sql.append("where isbn = ").append(id);
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(Integer.parseInt(rs.getString("price")));
				book.setContent(rs.getString("content"));
				book.setImg(rs.getString("img"));
				result = book;
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return result;
	}

	@Override
	public List<Book> search() throws SQLException {
		List<Book> list = new ArrayList<Book>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"select * from book \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book Book = new Book();
				Book.setIsbn(rs.getString("isbn"));
				Book.setTitle(rs.getString("title"));
				Book.setAuthor(rs.getString("author"));
				Book.setPrice(Integer.parseInt(rs.getString("price")));
				Book.setContent(rs.getString("content"));
				Book.setImg(rs.getString("img"));
				list.add(Book);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

}
