package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO idCheck(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.idCheck", userid);
		return dto;
	}

}
