package com.aoide.member._14_ScoreSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.member._14_ScoreSong.model.ScoreInService;
import com.aoide.member._14_ScoreSong.model.ScoreService;

@WebServlet("/GetScoreServlet.member")
public class GetScoreServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Integer songId1 = (Integer) session.getAttribute("song1");
		
		
//		request.setAttribute("song2", songId1);
		
		request.setCharacterEncoding("UTF-8");
		session.removeAttribute("fulks");
		
		session.getAttribute("getScore");
		
		
//		String a = request.getParameter("result");
//		Integer songId = Integer.parseInt(a);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		Integer memberId = member.getMemberId();
		
		
		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setSongId(songId1);
		scoreVO.setMemberId(memberId);

		session.setAttribute("scoreVO", scoreVO);
//		new ScoreService().calculatorAVG(songId1);
		
		
		
		

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/CommentServlet");
//		response.sendRedirect(contextPath + "/views/member/_14_Score.view/getScore1.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);

		}

}

