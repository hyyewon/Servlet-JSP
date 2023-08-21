package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public PageDTO list(HashMap<String, String> map, int curPage) {
		PageDTO pageDTO = null; //try 블럭 안에서 선언하면 return 해줄 수 없기 때문에 밖에서 선언
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			//DAO연동코드
			BoardDAO dao = new BoardDAO();
			pageDTO = dao.list(session, map, curPage); //try 블럭 안에서는 선언만 해줌
			
		}finally {
			session.close();
		}
		return pageDTO;
	}

	@Override
	public int write(BoardDTO dto) {
		int n=0; //리턴타입에 해당하는 변수
		SqlSession session = MySqlSessionFactory.getSession();
		try { //안에서 설정
			BoardDAO dao = new BoardDAO();
			n = dao.write(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		
		return n; //리턴타입 변수 리턴
	}

	@Override
	public BoardDTO retrieve(int num) {
		BoardDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			//조회수 증가
			int n=dao.readcnt(session, num);
			session.commit();
			//자세히 보기
			dto = dao.retrieve(session, num);
		}finally {
			session.close();
		}
		return dto;
	}

	@Override
	public int update(BoardDTO dto) {
		int n=0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			n = dao.update(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		
		return n;
	}

	@Override
	public int delete(int num) {
		int n=0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			BoardDAO dao = new BoardDAO();
			n = dao.delete(session, num);
			session.commit();
		}finally {
			session.close();
		}
		
		
		return 0;
	}

	

}
