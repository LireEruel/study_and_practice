package com.ssafy.member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;
import com.ssafy.util.DBUtil;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	
	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return memberDao.idCheck(userId);
	}

	@Override
	public int joinMember(MemberDto memberDto) throws Exception {
		return memberDao.joinMember(memberDto);
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws Exception {
		return memberDao.loginMember(userId, userPwd);
	}

}
