package com.ssafy.ws.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dto.User;

@Service
public interface UserService {
	public User select(String id) throws SQLException;
}
