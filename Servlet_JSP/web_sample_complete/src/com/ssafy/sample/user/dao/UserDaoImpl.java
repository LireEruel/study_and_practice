package com.ssafy.sample.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.user.UserDto;
import com.ssafy.sample.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	private static UserDao userDao = new UserDaoImpl();
	private DBUtil dbUtil;
	
	public UserDaoImpl() {
		this.dbUtil = DBUtil.getInstance();
	}
	
	public static UserDao getUserDao() {
		return userDao;
	}

	@Override
	public UserDto login(String id, String pwd) throws SQLException {
		UserDto userDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select user_id, user_name \n");
			sql.append("from members \n");
			sql.append("where user_id = ? and user_password = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userDto = new UserDto();
				userDto.setId(rs.getString("user_id"));
				userDto.setName(rs.getString("user_name"));
			}			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return userDto;
	}
	
}
