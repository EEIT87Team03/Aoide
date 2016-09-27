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
import com.aoide.member._14_ScoreSong.model.ScoreService;


@WebServlet("/DisplaySongServlet")
public class DisplaySongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//從JSP來的值，為歌曲的ID
		request.setCharacterEncoding("UTF-8");
		
//		    HttpSession session = request.getSession();
//			Integer song_id = (Integer) session.getAttribute("song1");
		
		Integer song_id=8;
		Integer s = 10 ;

		SongVO songVOinfo = new DisplayDongService().getSongById(song_id);
		
		request.getSession().setAttribute("songVO", songVOinfo);
		
       
		ScoreVO value = new ScoreService().calculatorAVG(song_id);
		
		request.getSession().setAttribute("value", value);
		
		
		
	    List<ScoreVO> one =  new ScoreInService().ScoreSong(song_id);
	    request.getSession().setAttribute("comments", one);

	
		  
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/global/_03_DisplaySong.view/ShowSongInfo.jsp");

		}
			
		
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
