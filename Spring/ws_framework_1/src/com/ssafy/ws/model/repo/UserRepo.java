package com.ssafy.ws.model.repo;

import java.sql.SQLException;

import com.ssafy.ws.model.dto.User;

public interface UserRepo {
	public User select(String id) throws SQLException;
}
