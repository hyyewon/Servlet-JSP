package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8090/xxx/hello
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//html 작성해서 응답처리하는 작성해야 된다.
		//만들려면 힘들어서 jsp로 넘긴 후 html로 응답할 수 있도록 구성된 패턴이 MVC 패턴임
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head><body>");
		out.print("서블릿 실습!");
		out.print("</body></html>");
	}

}
