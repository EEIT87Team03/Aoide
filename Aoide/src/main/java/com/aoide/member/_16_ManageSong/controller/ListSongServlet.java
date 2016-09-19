package com.aoide.member._16_ManageSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.member._16_ManageSong.model.ListSongService;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

@WebServlet("/ListSongServlet")
public class ListSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<SongVO> mySongResult = new ListSongService().getMySong();
		for (SongVO mySong : mySongResult) {
			System.out.println(mySong.getName());
		}
		
		request.getSession().setAttribute("mySongList", mySongResult);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_16_ManageSong.view/ListSong.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
