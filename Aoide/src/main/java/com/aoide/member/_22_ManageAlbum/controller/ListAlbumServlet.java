package com.aoide.member._22_ManageAlbum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;
import com.aoide.member._22_ManageAlbum.model.ListAlbumService;

@WebServlet("/ListAlbumServlet")
public class ListAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<AlbumVO> myAlbumResult = new ListAlbumService().getMyAlbum();
		for (AlbumVO myAlbum : myAlbumResult) {
			System.out.println(myAlbum.getName());
		}
		
		List<SongVO> mySongResult = new ListSongService().getMySong();
		for (SongVO mySong : mySongResult) {
			System.out.println(mySong.getName());
		}
		
		request.getSession().setAttribute("mySongList", mySongResult);
		request.getSession().setAttribute("myAlbumList", myAlbumResult);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/ListAlbum.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
