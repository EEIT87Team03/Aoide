package com.aoide.member._14_ScoreSong.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
		Integer songId1 = (Integer) session.getAttribute("song1");
		

//		Integer songId = Integer.parseInt(request.getParameter("songId"));
		
//		Integer songId = Integer.parseInt(request.getParameter("id"));
		
//		int song = 8;
		
		request.setCharacterEncoding("UTF-8");
		
	    List<ScoreVO> fulk =  new ScoreInService().ScoreSong(songId1);
	    request.getSession().setAttribute("fulks",fulk);

	   


		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_14_Score.view/getScore1.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
