package com.aoide.global._10_SearchSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._10_SearchSong.model.SearchSongService;
import com.aoide.global.dataBaseManipulationObjects.album.AlbumService;
import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;


@WebServlet("/ListSongsOfAlbum")
public class ListSongsOfAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get album id
		request.setCharacterEncoding("UTF-8");
//		Integer albumId = new Integer( request.getParameter("albumId").trim() );
		Integer albumId = 1;
		
		// call service get songs by album id and albumVO
		List<SongVO> songs = new SearchSongService().getSongsByAlbum(albumId);
		AlbumVO album = new AlbumService().getAlbumBean(albumId);
		
		// put songs in session
		request.getSession().setAttribute("songs", songs);
		request.getSession().setAttribute("album", album);
		
		// go to xxx.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/global/_03_DisplaySong.view/AlbumInfo.jsp");
		
	}

}
