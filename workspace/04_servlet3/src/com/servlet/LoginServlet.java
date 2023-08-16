package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");

		// DB연동해서 인증했다고 가정.

		// 세션 얻기
		HttpSession session = request.getSession();

		// 브라우저당 하나씩 저장소가 만들어지며, 해당 저장소에는 id가 부여됨
		System.out.println("세션의 id값 : " + session.getId());

		// HttpSession 저장소에 필요한 사용자 정보 저장
		session.setAttribute("user", userid);
		session.setAttribute("pass", passwd);

		// 응답처리 (로그인 이후 화면 처리)
		response.setContentType("text/html;charset=utf-8"); // MIME 타입 설정
		PrintWriter out = response.getWriter(); // 데이터를 전달하기 위한 java I/O
		out.print("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<h1>로그인성공</h1>");
		out.print("안녕하세요. "+userid+"님");
		out.print("<a href='mypage'>mypage</a>");
		
		out.print("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
