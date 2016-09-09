package com.aoide.member._16_ManageSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

@WebServlet("/editSongServlet")
public class editSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		List<SongVO> songVO;
		HttpSession session = null;
		
		// get the song id
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id").trim();
		if(idStr != null && idStr.length() != 0){
			id = Integer.parseInt(idStr);
		}
		
		// get the songVO by id from session
		session = request.getSession();
		songVO = (List<SongVO>) session.getAttribute("mySongList"); // from ListSongServlet
		
		// put the suggestionVO in session
		for(SongVO aSong:songVO){
			if(aSong.getSongId() == id){
				session.setAttribute("aSong", aSong);
			}
		}
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_16_ManageSong.view/editSong.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
