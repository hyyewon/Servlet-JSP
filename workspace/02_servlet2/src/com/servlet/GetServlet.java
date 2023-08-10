package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/get")
public class GetServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("GetServlet");
		
		/*
		 * 실행 1. 실행 후 url만 set-> get으로 바꿔서 요청 : session / application
		 * 
		 * 실행 2. 같은 브라우저로 get url 입력 : session / application
		 * 
		 * 실행 3. 다른 브라우저로 get url 입력 : application
		 * 
		 * 실행 4. 크롬 브라우저 모두 닫고 get url 입력 : application
		 * 
		 * 서블릿을 실행하면 요청이 되었으므로 request 저장소는 삭제되어 안에 입력된 데이터도 찾을 수 없게 된다.
		 *  
		 */
		
		//1.request scope 에 값 조회
		String x = (String)request.getAttribute("request");
		
		//2.session scope 에 값 조회
		HttpSession session = request.getSession();
		String x2 = (String)session.getAttribute("session");
		 
		//3.application scope 에 값 조회
		ServletContext ctx = getServletContext();
		String x3 = (String)ctx.getAttribute("application");
		
		System.out.println("request" + x);
		System.out.println("session" + x2);
		System.out.println("application" + x3);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
