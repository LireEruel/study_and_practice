package com.ssafy.sample.user.dao;

import java.sql.SQLException;

import com.ssafy.sample.user.UserDto;

public interface UserDao {
	
	UserDto login(String id, String pwd) throws SQLException;
	
}
