package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청 URL : http://localhost:8090/01_servlet/test
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("LoginServlet.doGet");
		
		//사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr");
		
		System.out.println(userid+"\t"+passwd+"\t"+xxx);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("LoginServlet.doPost");
		// POST 한글처리
		request.setCharacterEncoding("utf-8");
				
		//사용자 입력 데이터 얻기
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String xxx = request.getParameter("addr");
		
		System.out.println(userid+"\t"+passwd+"\t"+xxx);
	
	}

}
