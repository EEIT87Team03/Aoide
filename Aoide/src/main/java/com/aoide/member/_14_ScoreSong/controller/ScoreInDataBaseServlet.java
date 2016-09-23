package com.aoide.member._14_ScoreSong.controller;


import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.member._14_ScoreSong.model.ScoreInService;


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

		request.setCharacterEncoding("UTF-8");
		
		
		System.out.println(request.getParameter("socreStar"));
		Integer getStarResult = Integer.parseInt(request.getParameter("socreStar"));
        String comment =request.getParameter("comment");
        
        System.out.println("comment: " + comment);
        
       
        scoreVO.setScoreValue(getStarResult);
        scoreVO.setComment(comment);
		
		// test insert
		new ScoreInService().insert(scoreVO);
		
		
		  List<ScoreVO> all_comment = new ScoreInService().getComment_D();
		  for(ScoreVO one : all_comment){
			  one.getComment();
			     
	    request.getSession().setAttribute("comments", one);}

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_14_Score.view/getScore1.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response);
	}
}
