package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청 URL : http://localhost:8090/01_servlet/test
@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	
	//인스턴스 변수 : 공유 가능
	int num;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num2 = 0; //로컬 변수: 공유 불가
		
		num++;
		num2++;
		
		System.out.println("thread-unsafe: "+num);
		System.out.println("thread-safe: "+num2);
	}

}
