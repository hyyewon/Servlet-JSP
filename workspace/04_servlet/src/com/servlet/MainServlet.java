package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//요청처리할때 사용하는 서블릿
//http://localhost:8090/04_servlet/main
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("MainServlet");
		//요청위임1. 포워드(forward)
		
		//scope에 저장
		request.setAttribute("request", "request");
		HttpSession session = request.getSession();
		session.setAttribute("session", "session");
		ServletContext application = getServletContext();
		application.setAttribute("application", "application");
		
		
		//가.URL이 변경 안됨. 이유는 request가 확장되었기 때문(요청부터 응답까지 끌고감)
		//따라서 위임받은 서블릿에서 request에 저장된 데이터를 가져올 수 있다.
		request.getRequestDispatcher("response").forward(request, response);
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
