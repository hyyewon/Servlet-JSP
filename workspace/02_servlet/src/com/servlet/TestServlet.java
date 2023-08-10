package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 

 public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("TestServlet" + getServletName());
		//ServletConfig 의 getInitParameter(name)
		String dir_path = getInitParameter("dir_path");
		String email = getInitParameter("email");
		System.out.println(dir_path+"\t"+email);
		
		//ServletContext 의 getInitParameter(name) - 모든 서블릿에서 사용 가능
		ServletContext ctx = getServletContext(); //ServletContext 얻고
		String userid = ctx.getInitParameter("userid"); //변수.메서드명
		String passwd = ctx.getInitParameter("passwd");
		System.out.println(userid+"\t"+passwd);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
