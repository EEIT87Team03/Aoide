package com.aoide.member._41_ScoreSong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._41_ScoreSong.model.ScoreSongService;
import com.aoide.member._41_ScoreSong.model.ScoreVO;

@WebServlet("/ScoreSongServlet")
public class ScoreSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Fields
	WebApplicationContext context = null;
	
	// Methods
	@Override
	public void init() throws ServletException {
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		// get parameters
		Integer memberId = member.getMemberId();
		Integer songId = new Integer(request.getParameter("songid").trim());
		Integer score = new Integer(request.getParameter("score").trim());
		String comment = request.getParameter("comment");
		
		// set parameters into vo 
		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setMemberId(memberId);
		scoreVO.setSongId(songId);
		scoreVO.setScoreValue(score);
		scoreVO.setComment(comment);
		
		// call service
		DataSource ds = (DataSource) context.getBean("dataSource");
		ScoreSongService service = new ScoreSongService(ds);
		service.scoreSong(scoreVO);
		
		// go xxx.jsp
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
