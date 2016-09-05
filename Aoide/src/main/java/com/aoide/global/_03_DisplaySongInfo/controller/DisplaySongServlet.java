package com.aoide.global._03_DisplaySongInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._03_DisplaySongInfo.model.DisplayDongService;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;


@WebServlet("/DisplaySongServlet")
public class DisplaySongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//從JSP來的值，為歌曲的ID
		Integer song_id = 2;
		
		SongVO songVO = new DisplayDongService().getSongById(song_id);
		
		request.getSession().setAttribute("songVO", songVO);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_03_DisplaySong.view/ShowSongInfo.jsp");
		
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
