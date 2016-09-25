package com.aoide.member._14_ScoreSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global._10_SearchSong.model.SearchSongService;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;


@WebServlet("/GetSongInfo")
public class GetSongInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GetSongInfo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        
		
		Integer songId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("song1", songId);

		List<SongVO> point =  new SearchSongService().getSongOne(songId);
		request.getSession().setAttribute("getScore", point);
		
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/GetScoreServlet.member");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
