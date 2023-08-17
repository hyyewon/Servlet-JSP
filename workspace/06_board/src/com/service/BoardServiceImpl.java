package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<BoardDTO> list() {
		List<BoardDTO> list = null; //try 블럭 안에서 선언하면 return 해줄 수 없기 때문에 밖에서 선언
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			//DAO연동코드
			BoardDAO dao = new BoardDAO();
			list = dao.list(session); //try 블럭 안에서는 선언만 해줌
			
		}finally {
			session.close();
		}
		return list;
	}

}
