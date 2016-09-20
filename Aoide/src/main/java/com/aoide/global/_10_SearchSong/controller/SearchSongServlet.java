package com.aoide.global._10_SearchSong.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._00_TestUtil.Validator;
import com.aoide.global._10_SearchSong.model.SearchSongService;
import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
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
		Map<String,String> errorMsg = new HashMap<>();
		String contextPath = request.getContextPath();
		
		if(!Validator.isValidString(search)){
			errorMsg.put("emptySearchMsg", "請輸入搜尋字串");
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("/views/global/_10_SearchSong.view/SearchSong.jsp").forward(request, response);
			return;
		}else{
			if(type.equalsIgnoreCase("name")){
				List<SongVO> searchResult = new SearchSongService().getSongName(search);
				for (SongVO searchSong : searchResult) {
					System.out.println("符合的歌名：" + searchSong.getName());
				}
				
				request.getSession().setAttribute("type1", "歌名搜尋結果");
				request.getSession().setAttribute("searchList", searchResult);
				response.sendRedirect(contextPath + "/views/global/_10_SearchSong.view/SearchSongResult.jsp");
				
			}else if(type.equalsIgnoreCase("singer")){
				List<SongVO> searchResult = new SearchSongService().getSinger(search);
				for (SongVO searchSong : searchResult) {
					System.out.println("符合的歌手：" + searchSong.getSinger());
				}
				
				request.getSession().setAttribute("type1", "歌手搜尋結果");
				request.getSession().setAttribute("searchList", searchResult);
				response.sendRedirect(contextPath + "/views/global/_10_SearchSong.view/SearchSongResult.jsp");
				
			}else if(type.equalsIgnoreCase("album")){
				List<AlbumVO> searchResult = new SearchSongService().getAlbum(search);
				for (AlbumVO searchSong : searchResult) {
					System.out.println("符合的專輯：" + searchSong.getName());
				}
				
				request.getSession().setAttribute("type1", "專輯搜尋結果");
				request.getSession().setAttribute("searchList", searchResult);
				response.sendRedirect(contextPath + "/views/global/_10_SearchSong.view/SearchAlbumResult.jsp");
			}
		}
		
	}

}
