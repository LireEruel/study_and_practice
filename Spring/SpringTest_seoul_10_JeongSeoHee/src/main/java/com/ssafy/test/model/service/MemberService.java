package com.ssafy.test.model.service;

import com.ssafy.test.exception.LoginFailedException;
import com.ssafy.test.model.MemberDto;

public interface MemberService {
	MemberDto login(MemberDto memberDto) throws Exception;	//로그인
}
