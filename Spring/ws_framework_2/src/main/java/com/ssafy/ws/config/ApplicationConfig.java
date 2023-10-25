package com.ssafy.ws.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.ssafy.ws.aop.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.ssafy.ws"})
public class ApplicationConfig {

	@Bean
	public DataSource setDataSourse() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ssafy_ws_5th?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		dataSource.setUsername("ssafy");
		dataSource.setPassword("ssafy");
		return dataSource;
	}
	
	@Bean
	public LoggingAspect getLoggingAspect() {
		return new LoggingAspect();
	}
}
