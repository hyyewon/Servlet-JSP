package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {
	
	public PageDTO list(SqlSession session, int curPage) {
		
		//PageDTO에 4개의 데이터 저장해서 반환만 해주면 jsp에서 필요할 때 꺼내씀
		/*
		 * 	List<BoardDTO> list;
		 * int perPage=3;
		 * int curPage;
		 * int totalCount;
		 */
		
		PageDTO pageDTO = new PageDTO();
		
		//시작위치=(현재페이지-1)*페이지당 보여줄 개수
		int offset=(curPage-1)*pageDTO.getPerPage(); //curPage는 화면단에서 DAO까지 정보가 넘어옴
		//테이블에서 얻을 데이터 개수
		int limit=pageDTO.getPerPage();
		//RowBoundsdp 의해 3개의 레코드가 저장됨
		List<BoardDTO> list=session.selectList("BoardMapper.list", null, 
												new RowBounds(offset, limit));
		//그냥 RowBounds를 넣으면 모든 레코드 반환

		//pageDTO에 4가지 정보 저장
		pageDTO.setList(list);
		//현재 페이지 저장
		pageDTO.setCurPage(curPage);
		//전체레코드 개수 저장
		int totalCount=session.selectOne("BoardMapper.totalCount");
		pageDTO.setTotalCount(totalCount);
		
		return pageDTO;
	}

}
