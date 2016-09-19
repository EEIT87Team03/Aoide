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

@WebServlet("/EditSongServlet")
public class EditSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		List<SongVO> songS;
		HttpSession session = null;
		
		// get the song id
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id").trim();
		if(idStr != null && idStr.length() != 0){
			id = Integer.parseInt(idStr);
		}
		
		// get the songVO by id from session
		session = request.getSession();
		songS = (List<SongVO>) session.getAttribute("mySongList"); // from ListSongServlet
		
		// put the songVO in session
		for(SongVO song:songS){
			if(song.getSongId() == id){
				session.setAttribute("song", song);
			}
		}
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_16_ManageSong.view/EditSong.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
