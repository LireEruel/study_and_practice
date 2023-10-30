package com.ssafy.test.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.test.exception.LoginFailedException;
import com.ssafy.test.model.MemberDto;
import com.ssafy.test.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;
	
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}


	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		MemberDto result = null;
		result = memberMapper.login(memberDto);
		if(result == null) {
			throw new Exception("로그인 실패");
		}
		return result;
	}

}
