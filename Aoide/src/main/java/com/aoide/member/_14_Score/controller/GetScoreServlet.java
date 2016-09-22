package com.aoide.member._14_Score.controller;

import java.io.IOException;
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
import com.aoide.member._14_Score.model.ScoreService;

@WebServlet("/GetScoreServlet")
public class GetScoreServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("Test doGet");

		List<ScoreVO> point = new ScoreService().getPoint();

		request.getSession().setAttribute("getScore", point);

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_14_Score.view/getScore1.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		

//		HttpSession session = null;
//		ScoreVO score = null;
//		ScoreVO scoreValue = null;
//		ScoreService scoreService = null;
//
//		request.setCharacterEncoding("UTF-8");
//		String point = request.getParameter("e").trim();
//
//		if (point != null && point.length() != 0) {// having reply content,
//													// replyState = 1
//			// update replyState and replyContentFile
//			session = request.getSession();
//			score = (ScoreVO) session.getAttribute("score");
//			session.removeAttribute("score");
//			score.setScoreValue(1);
//			score.setSongId(1);
//
//			System.out.println("score: " + score);

		}

	}

