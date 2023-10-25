package com.ssafy.util;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {

//	private final String driverName = "com.mysql.cj.jdbc.Driver";
//	private final String url = "jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
//	private final String user = "ssafy";
//	private final String pass = "ssafy";


	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
