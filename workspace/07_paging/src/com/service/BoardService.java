package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dto.PageDTO;

public interface BoardService {
	public PageDTO list(int curPage);

}
