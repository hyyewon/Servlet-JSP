package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션 얻기
		HttpSession session = request.getSession();
		
		//세션에서 로그인 정보 얻기
		String id = (String)session.getAttribute("user");
		
		//조건에 의해 화면처리를 다르게 만들어줌
		if(id != null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head>");
			out.print("<meta charset=\"UTF-8\">");
			out.print("<title>Insert title here</title>");
			out.print("</head>");
			out.print("<body>");
			
			out.print("<h1>mypage</h1>");
			out.print("안녕하세요. "+id+"님");
			out.print("<a href='logout'>로그아웃</a>");
			
			out.print("</body></html>");
		}else {
			//id값이 null ==> 로그인을 하지 않은 경우 || 로그인 했는데 time-out되는 경우
			response.sendRedirect("loginForm.jsp");
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
