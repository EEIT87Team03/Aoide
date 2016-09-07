package com.aoide.global._10_SearchSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._10_SearchSong.model.SearchSongService;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;

@WebServlet("/SearchSongServlet")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("searchSong");

		List<SongVO> searchResult = new SearchSongService().getSongName(search);

		for (SongVO searchSong : searchResult) {
			System.out.println(searchSong.getName());
		}

		request.getSession().setAttribute("searchList", searchResult);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_10_SearchSong.view/SearchSongResult.jsp");
		
	}

}
