package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao = new MemberDaoImpl();
	private DBUtil dbUtil;
	
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
    public int idCheck(String userId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtil.getConnection();
            StringBuilder loginMember = new StringBuilder();
            loginMember.append("select count(user_id)\n");
            loginMember.append("from members \n");
            loginMember.append("where user_id = ? \n");
            pstmt = conn.prepareStatement(loginMember.toString());
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            rs.next();
            int cnt = rs.getInt(1);
            return cnt > 0 ? 1 : 0;
        } finally {
            dbUtil.close(rs, pstmt, conn);
        }
    }
	
	@Override
	public int joinMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			System.out.println(memberDto);
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("insert into members \n");
			loginMember.append("values(? , ? , ? , ? , ? , ?)");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPwd());
			pstmt.setString(4, memberDto.getEmailId());
			pstmt.setString(5, memberDto.getEmailDomain());
			pstmt.setString(6,  new Date().toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(rs.getString("user_id"));
				memberDto.setUserName(rs.getString("user_name"));
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select user_id, user_name \n");
			loginMember.append("from members \n");
			loginMember.append("where user_id = ? and user_password = ? \n");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(rs.getString("user_id"));
				memberDto.setUserName(rs.getString("user_name"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

}
