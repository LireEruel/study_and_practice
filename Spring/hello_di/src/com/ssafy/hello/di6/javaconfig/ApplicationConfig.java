package com.ssafy.hello.di6.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정파일임을 알려준다
@ComponentScan(basePackages = {"com.ssafy.hello.di6"})
public class ApplicationConfig {
	
}
