package com.aoide.member._14_ScoreSong.controller;

import java.awt.Point;
import java.beans.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.score.JdbcScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;
import com.aoide.manager._27_ReplySuggestions.model.SuggestionService;
import com.aoide.member._14_ScoreSong.model.ScoreInService;
import com.aoide.member._14_ScoreSong.model.ScoreService;

@WebServlet("/ScoreInDataBaseServlet.member")
public class ScoreInDataBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	public ScoreInDataBaseServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		ScoreVO scoreVO = (ScoreVO) session.getAttribute("scoreVO");

		
		System.out.println(request.getParameter("socreStar"));
		Integer getStarResult = Integer.parseInt(request.getParameter("socreStar"));
        String comment =request.getParameter("comment");
        
        
        scoreVO.setScoreValue(getStarResult);
        scoreVO.setComment(comment);
		
		// test insert
		new ScoreInService().insert(scoreVO);
		

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_14_Score.view/getScore1.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response);
	}
}
