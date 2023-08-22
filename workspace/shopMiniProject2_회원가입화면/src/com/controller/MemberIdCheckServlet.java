package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//아이디 중복 확인, 화면 처리 불필요 -> ajex 활용
		String userid = request.getParameter("userid");
		
		MemberService service = new MemberServiceImpl();
		MemberDTO dto = service.idCheck(userid);
		
		String mesg="아이디 사용 가능";
		if(dto!=null) {
			mesg = "아이디 중복";
		}
		
		//응답처리
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(mesg); //메세지를 호출한 곳에 출력 - member.jsp
		
	}

}
