package com.aoide.member._16_ManageSong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;

@WebServlet("/UpdateSongServlet")
public class UpdateSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		SongVO song = null;
		SongVO updateSong = null;
		ListSongService lss = null;
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name").trim();
		String singer = request.getParameter("singer").trim();
		String songType = request.getParameter("songType").trim();
		String songLanguage = request.getParameter("songLanguage").trim();
		String introductionFile = request.getParameter("introductionFile").trim();
		String lyricsFile = request.getParameter("lyricsFile").trim();
		
		if (name != null && name.length() != 0){// having content and update
			session = request.getSession();
			song = (SongVO) session.getAttribute("aSong");
			session.removeAttribute("aSong");			
			song.setName(name);
			song.setSinger(singer);
			song.setSongType(songType);
			song.setSongLanguage(songLanguage);
			song.setIntroductionFile(introductionFile);
			song.setLyricsFile(lyricsFile);
			
			System.out.println("song: " + song);
			System.out.println("song: " + song.getName());
			System.out.println("song: " + song.getSinger());
			System.out.println("song: " + song.getSongType());
			System.out.println("song: " + song.getSongLanguage());
			System.out.println("song: " + song.getIntroductionFile());
			System.out.println("song: " + song.getLyricsFile());
			
			// update song
			lss = new ListSongService();
			lss.updateSong(song);			
			System.out.println("update song success");
		}else{// no content
			System.out.println("no input name");
		}
		
		// get the song from database to check the result of update
		updateSong = lss.getSongById(song.getSongId());
		session.setAttribute("updateSong", updateSong);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_16_ManageSong.view/editSongSuccess.jsp");
	}

}
