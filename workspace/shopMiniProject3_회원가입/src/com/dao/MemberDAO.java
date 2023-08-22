package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	//아이디 중복 확인
	public MemberDTO idCheck(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.idCheck", userid);
		return dto;
	}
	
	//회원가입
	public int memberAdd(SqlSession session, MemberDTO dto) {
		int n=session.insert("MemberMapper.memberAdd",dto);
		return n;
	}

}
