package com.aoide.manager._28_ManageAccusement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;

/**
 * Servlet implementation class BanMemberServlet
 */
@WebServlet("/BanMemberServlet")
public class BanMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get accused account
		String accusedAccount = request.getParameter("accusedAccount").trim();
		// call service to get memberVO from DB and update banState
		MemberService memberService = new MemberService();
		MemberVO accused = memberService.getMemberBean(accusedAccount);
		accused.setBanState(true);
		
		System.out.println("BanState: " + accused.getBanState());
		memberService.updateMemberData(accused);
		// go to ListAccusementServlet
		request.getRequestDispatcher("/ListAccusementServlet.manager").forward(request, response);
		return;
	}

}
