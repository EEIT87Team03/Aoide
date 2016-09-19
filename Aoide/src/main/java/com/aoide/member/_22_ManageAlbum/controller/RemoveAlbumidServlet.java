package com.aoide.member._22_ManageAlbum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;

@WebServlet("/RemoveAlbumidServlet.member")
public class RemoveAlbumidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		List<SongVO> songS;
		HttpSession session = null;
		ListSongService service = new ListSongService();
		
		// get the song id
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id").trim();
		if(idStr != null && idStr.length() != 0){
			id = Integer.parseInt(idStr);
		}
		
		// get the songVO by id from session
		session = request.getSession();
		songS = (List<SongVO>) session.getAttribute("mySongList"); // from ListSongServlet
		AlbumVO album = (AlbumVO) session.getAttribute("album");
		int albumId = album.getAlbumId();
		
		// put the songVO in session
		for(SongVO song:songS){
			if(song.getSongId() == id){
				System.out.println("移出專輯 " + albumId + " 的songId：" + song.getSongId());
				song.setAlbumId(1);
				service.updateSong(song);
			}
		}
		response.sendRedirect("EditAlbumServlet?id=" + albumId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
