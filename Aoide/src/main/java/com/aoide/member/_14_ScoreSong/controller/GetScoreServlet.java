package com.aoide.member._14_ScoreSong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.ConnectionBean;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;
import com.aoide.manager._27_ReplySuggestions.model.SuggestionService;
import com.aoide.member._14_ScoreSong.model.ScoreInService;
import com.aoide.member._14_ScoreSong.model.ScoreService;

@WebServlet("/GetScoreServlet.member")
public class GetScoreServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	     int memberId =1;
	     int songId =5;
		
		
		ScoreVO point = new ScoreService().getScoreById(memberId, songId);
//		List<ScoreVO> point =  new ScoreService().getPoint();
		request.getSession().setAttribute("getScore", point);
		
	
		

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_14_Score.view/getScore1.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		}

}

