package com.ssafy.test.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.test.model.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto login(MemberDto memberDto) throws Exception;
}
