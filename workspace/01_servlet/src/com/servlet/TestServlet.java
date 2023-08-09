package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청 URL : http://localhost:8090/01_servlet/test
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	
	@Override
	public void destroy() { //삭제 또는 reload할때 호출됨
		System.out.println("TestServlet.destroy");
	}

	
	@Override
	public void init(ServletConfig config) throws ServletException { //서블릿도 class이기 때문에 생성해야 (메모리에 올라가야) 함(Tomcat이 해줌)
		System.out.println("TestServlet.init");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//웹 브라우저가 아닌 Tomcat 서버의 콘솔에 출력됨. (servlet에서 html안만들었기 때문)
		System.out.println("TestServlet.doGet");
	}

}
