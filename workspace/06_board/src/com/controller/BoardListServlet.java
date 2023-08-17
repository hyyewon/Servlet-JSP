package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//BoardService 연동
		BoardService service = new BoardServiceImpl();
		List<BoardDTO> list = service.list();
		
		//이전에는 서블릿에서 응답처리를 했음 => 지금은 list.jsp한테 위임
		//list.jsp에서 List<BoardDTO> 보여주기 위해서는
		//List<BoardDTO>를 scope에 저장해야 된다. 목록보기는 request scope에 저장하는 것이 가장 최적
		/*
		 * request scope (*)
		 * session scope
		 * application scope
		 */
		request.setAttribute("boardList", list);
		
		//요청위임 : 서블릿에서 저장한 request를 (request scope) jsp까지 확장시켜야 되므로 (동일 request를 사용해야 함) 포워드 사용
		/*
		 * forward (*)
		 * redirect
		 */
		request.getRequestDispatcher("list.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
