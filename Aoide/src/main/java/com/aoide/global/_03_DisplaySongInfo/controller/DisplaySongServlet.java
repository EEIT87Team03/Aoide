package com.aoide.global._03_DisplaySongInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global._03_DisplaySongInfo.model.DisplayDongService;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._14_ScoreSong.model.ScoreInService;


@WebServlet("/DisplaySongServlet")
public class DisplaySongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get song id
		request.setCharacterEncoding("UTF-8");
		
		Integer songId = 1;
//		Integer songId = new Integer( request.getParameter("songId") );
		
	    // call service to get the song and scores of the song
		SongVO song = new DisplayDongService().getSongById(songId);
		List<ScoreVO> scores =  new ScoreInService().ScoreSong(songId);
		
		// put song and scores in session
		HttpSession session = request.getSession();
		session.setAttribute("song", song);
		session.setAttribute("scores", scores);
		
		// go to SongInfo.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/global/_03_DisplaySong.view/SongInfo.jsp");
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
