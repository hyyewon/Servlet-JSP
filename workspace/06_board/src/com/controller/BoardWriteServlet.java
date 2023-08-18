package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//브라우저에서 작성한 내용 저장
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		
		//DTO에 저장해서 Service -- DAO까지 전달
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setContent(content);
		
		//서비스 연동
		BoardService service = new BoardServiceImpl();
		int n = service.write(dto);
		
		//요청위임 => 목록
		response.sendRedirect("list");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
