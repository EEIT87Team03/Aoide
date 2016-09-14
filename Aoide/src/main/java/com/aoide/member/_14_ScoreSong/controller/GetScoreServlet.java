package com.aoide.member._14_ScoreSong.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.member._14_ScoreSong.model.ScoreService;

@WebServlet("/GetScoreServlet.member")
public class GetScoreServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		Integer songId = new Integer(request.getParameter("songid"));
		HttpSession session = request.getSession();
		Integer songId = 9; 
//		String a = request.getParameter("result");
//		Integer songId = Integer.parseInt(a);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		Integer memberId = member.getMemberId();
		
		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setSongId(songId);
		scoreVO.setMemberId(memberId);
		
		session.setAttribute("scoreVO", scoreVO);
		
		new ScoreService().calculatorAVG(songId);
		
	
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_14_Score.view/getScore1.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		}

}

