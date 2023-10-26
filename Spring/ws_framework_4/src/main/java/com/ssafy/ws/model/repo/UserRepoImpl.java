package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.User;

@Repository
public class UserRepoImpl implements UserRepo {
	private DataSource dataSource;

	
	@Autowired
	public UserRepoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public User select(String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User result = null;
		try(Connection conn = dataSource.getConnection();) {
			
			StringBuilder sql = new StringBuilder();
			sql.append(
					"select * from user \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setRec_id(rs.getString("rec_id"));
				result = user;
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

}
