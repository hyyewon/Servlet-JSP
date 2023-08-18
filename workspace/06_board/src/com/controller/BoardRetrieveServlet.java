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

@WebServlet("/retrieve")
public class BoardRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String num = request.getParameter("num"); //jsp에서 넘긴 num값 가져오기
		
		//num을 서비스 --> DAO까지 전달해서 해당 내용 contents 보여주기
		BoardService service = new BoardServiceImpl();
		BoardDTO dto = service.retrieve(Integer.parseInt(num));
	
		//scope에 저장
		request.setAttribute("boardRetrieve", dto);
		//jsp로 요청 위임
		request.getRequestDispatcher("retrieve.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
