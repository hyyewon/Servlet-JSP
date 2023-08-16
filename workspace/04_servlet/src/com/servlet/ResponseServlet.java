package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//응답처리할때 사용하는 서블릿
@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("ResponseServlet");
	
	
	String s = (String)request.getAttribute("request");
	HttpSession session = request.getSession();
	String s2 = (String)session.getAttribute("session");
	ServletContext application = getServletContext();
	String s3 = (String)application.getAttribute("application");
	System.out.println("request:"+s);
	System.out.println("session:"+s2);
	System.out.println("application:"+s3);
	
	
	//응답처리
	response.setContentType("text/html;charset=utf-8"); //MIME 타입 설정
	PrintWriter out = response.getWriter(); //데이터를 전달하기 위한 java I/O
	 out.print("<html><head>");
	 out.print("<meta charset=\"UTF-8\">");
	 out.print("<title>Insert title here</title>");
	 out.print("</head>");
	 out.print("<body>");
	 out.print("<h1>ResponseServlet</h1>");
	 out.print("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
