package com.aoide.global._07_Register.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

/**
 * Servlet implementation class CheckAccountServlet
 */
@WebServlet("/CheckAccountServlet")
public class CheckAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the account from ajax request
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account").trim();
		
		// call service to check it up
		String isUsed;
		MemberService ms = new MemberService();
		MemberVO memberBean = ms.getMemberBean( account );
		if(memberBean == null){
			isUsed = "unused";
		}else{
			isUsed = "used";
		}
		
		// response the account is used or not
		response.setContentType("text//plain;charset=UTF-8");
		response.getWriter().write(isUsed);
	}

}
