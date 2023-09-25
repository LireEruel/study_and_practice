package com.ssafy.sample.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.user.UserDto;
import com.ssafy.sample.user.service.UserService;
import com.ssafy.sample.user.service.UserServiceImpl;

@WebServlet("/user")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = UserServiceImpl.getUserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		String path = "";
		if ("login".equals(action)) {
			path = login(req, resp);
			redirect(req, resp, path);
		} else if ("logout".equals(action)) {
			path = logout(req, resp);
			redirect(req, resp, path);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	private void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher(path);
		disp.forward(req, resp);
	}

	private void redirect(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException {
		resp.sendRedirect(req.getContextPath() + path);
	}

	// 로그인 함수
	private String login(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("login-id");
		String pwd = req.getParameter("login-pwd");
		try {
			// 입력한 id와 pwd가 맞다면 로그인
			UserDto userDto = userService.login(id, pwd);
			if (userDto != null) {
				// session 설정 : 세션에 유저 정보 저장
				HttpSession session = req.getSession();
				session.setAttribute("userinfo", userDto);
			}
			return "/index.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	// 로그아웃 : 세션에 저장된 유저 정보 삭제
	private String logout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "";
	}
}
