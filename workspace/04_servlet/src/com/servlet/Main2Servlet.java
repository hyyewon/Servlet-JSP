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
//http://localhost:8090/04_servlet/response
@WebServlet("/main2")
public class Main2Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("MainServlet");
		// 요청위임2. 리다이렉트(redirect)

		// scope에 저장
		request.setAttribute("request", "request");
		HttpSession session = request.getSession();
		session.setAttribute("session", "session");
		ServletContext application = getServletContext();
		application.setAttribute("application", "application");

		//가.URL이 변경됨. 위임받은 서블릿과 request가 다름
		//따라서 위임받은 서블릿에서는 request 값을 가지고 오지 못함. 
		response.sendRedirect("response");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
