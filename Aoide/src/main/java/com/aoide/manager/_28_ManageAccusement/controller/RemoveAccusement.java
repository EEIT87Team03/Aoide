package com.aoide.manager._28_ManageAccusement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.manager._28_ManageAccusement.model.ManageAccusementService;


@WebServlet("/RemoveAccusement")
public class RemoveAccusement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get id of accused and accusement
		Integer accusementId = new Integer(request.getParameter("accusementId").trim());
		String accusedAccount = request.getParameter("accusedAccount").trim();
		// change ban state of accused by id
		MemberService memberService = new MemberService();
		MemberVO accused = memberService.getMemberBean(accusedAccount);
		accused.setBanState(false);
		
		System.out.println("BanState: " + accused.getBanState());
		memberService.updateMemberData(accused);
		// delete accusement
		new ManageAccusementService().removeAccusement(accusementId);
		// go to ListAccusementServlet
		request.getRequestDispatcher("/ListAccusementServlet.manager").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
