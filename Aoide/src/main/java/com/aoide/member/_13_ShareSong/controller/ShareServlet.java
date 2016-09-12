package com.aoide.member._13_ShareSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.member._14_Score.model.ScoreService;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareServlet")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ScoreVO> point = new ScoreService().getPoint();

		request.getSession().setAttribute("getScore", point);

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_13_ShareSong.view/ShareSong.jsp");

	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
