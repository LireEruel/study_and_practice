package com.ssafy.sample.user.service;

import java.sql.SQLException;

import com.ssafy.sample.user.UserDto;
import com.ssafy.sample.user.dao.UserDao;
import com.ssafy.sample.user.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	
	private static UserService userService = new UserServiceImpl();
	private UserDao userDao;
	
	private UserServiceImpl() {
		userDao = UserDaoImpl.getUserDao();
	}
	
	public static UserService getUserService() {
		return userService;
	}

	@Override
	public UserDto login(String id, String pwd) throws SQLException {
		return userDao.login(id, pwd);
	}
	
	

}
