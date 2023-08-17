package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public class BoardDAO {
	
	//전체 목록
	public List<BoardDTO> list(SqlSession session){ //mapper의 id값으로 메서드 이름 일치시켜주기
		List<BoardDTO> list = session.selectList("BoardMapper.list");
		return list;
	}

}
