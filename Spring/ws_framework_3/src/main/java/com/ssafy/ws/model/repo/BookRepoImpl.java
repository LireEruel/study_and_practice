package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Book;

@Repository
public class BookRepoImpl implements BookRepo {

	private DataSource dataSource;

	@Autowired
	public BookRepoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public int insert(Book book) {
        String sql = "Insert Into book values (?, ?, ?, ?, ?, ?)";
        int res = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getPrice());
            pstmt.setString(5, book.getContent());
            pstmt.setString(6, book.getImg());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

	@Override
	public int update(Book book) throws SQLException {
		String sql = "Update book Set title = ?, author = ?, price = ?, content = ?, img = ? Where isbn = ?";
        int res = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPrice());
            pstmt.setString(4, book.getContent());
            pstmt.setString(5, book.getImg());
            pstmt.setString(6, book.getIsbn());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
	}

	@Override
	public int delete(String isbn) throws SQLException {
		 int res = 0;
	        String sql = "delete from book where isbn = ?";
	        try (Connection conn = dataSource.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, isbn);
	            res = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return res;
	}

	@Override
	public Book select(String isbn) {
        Book dto = new Book();
        String sql = "Select * From book Where isbn = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setIsbn(rs.getString("isbn"));
                dto.setTitle(rs.getString("title"));
                dto.setAuthor(rs.getString("author"));
                dto.setPrice(rs.getInt("price"));
                dto.setContent(rs.getString("content"));
                dto.setImg(rs.getString("img"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

	@Override
	public List<Book> search() {
        List<Book> dtos = new ArrayList<>();
        String sql = "Select * From book";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book dto = new Book();
                dto.setIsbn(rs.getString("isbn"));
                dto.setTitle(rs.getString("title"));
                dto.setAuthor(rs.getString("author"));
                dto.setPrice(rs.getInt("price"));
                dto.setContent(rs.getString("content"));
                dto.setImg(rs.getString("img"));
                dtos.add(dto);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtos;
    }

}
