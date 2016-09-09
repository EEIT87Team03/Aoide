package com.aoide.member._14_ScoreSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.member._14_ScoreSong.model.ScoreInService;
import com.aoide.member._14_ScoreSong.model.ScoreService;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet.member")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CommentServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		// form ScoreVO take Comment_file column 
	  List<ScoreVO> all_comment = new ScoreInService().getComment_D();
	  for(ScoreVO one : all_comment){
		     one.getComment();
		     
		     request.getSession().setAttribute("comments", one);

	  }
	  
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_14_Score.view/CommentPresent.jsp");

	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	}

}
