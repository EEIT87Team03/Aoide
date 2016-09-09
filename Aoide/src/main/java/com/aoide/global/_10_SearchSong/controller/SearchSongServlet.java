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
		processRequest(request, response);		
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("searchType");
		String search = request.getParameter("searchSong");
		
		if(type.equalsIgnoreCase("name")){
			List<SongVO> searchResult = new SearchSongService().getSongName(search);
			for (SongVO searchSong : searchResult) {
				System.out.println(searchSong.getName());
			}
			
			request.getSession().setAttribute("type1", "歌名搜尋結果");
			request.getSession().setAttribute("searchList", searchResult);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/_10_SearchSong.view/SearchSongResult.jsp");
			
		}else if(type.equalsIgnoreCase("singer")){
			List<SongVO> searchResult = new SearchSongService().getSinger(search);
			for (SongVO searchSong : searchResult) {
				System.out.println(searchSong.getSinger());
			}
			
			request.getSession().setAttribute("type1", "歌手搜尋結果");
			request.getSession().setAttribute("searchList", searchResult);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/_10_SearchSong.view/SearchSongResult.jsp");
		}
		
	}

}
