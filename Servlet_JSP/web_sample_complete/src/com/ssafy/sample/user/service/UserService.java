package com.ssafy.sample.user.service;

import java.sql.SQLException;

import com.ssafy.sample.user.UserDto;

public interface UserService {
	
	UserDto login(String id, String pwd) throws SQLException;

}
