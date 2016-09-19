package com.aoide.member._22_ManageAlbum.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;

@WebServlet("/EditAlbumServlet.member")
public class EditAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		List<AlbumVO> albumS;
		HttpSession session = null;
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		Integer memberId = member.getMemberId();
		
		// get the album id
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id").trim();
		if(idStr != null && idStr.length() != 0){
			id = Integer.parseInt(idStr);           //int
		}
		
		// get the albumVO by id from session
		session = request.getSession();
		albumS = (List<AlbumVO>) session.getAttribute("myAlbumList"); // from ListAlbumServlet
		
		// put the albumVO in session
		for(AlbumVO album:albumS){
			if(album.getAlbumId().intValue() == id){    //Integer
				session.setAttribute("album", album);
			}
		}
		
		List<SongVO> mySongResult = new ListSongService().getMySong(memberId);
		List<SongVO> songS = new ArrayList();
		for(SongVO song:mySongResult){
			if(song.getAlbumId() == id){    //int
				songS.add(song);
				System.out.println("屬於專輯 " + id + " 的songId：" + song.getSongId());
			}
		}
		
		List<SongVO> mySongResult2 = new ListSongService().getMyAlbumSong(memberId);
		for (SongVO mySong : mySongResult2) {
			System.out.println("未分類專輯的歌曲：" + mySong.getName());
		}
		
		request.getSession().setAttribute("mySongList", songS);
		request.getSession().setAttribute("mySongList2", mySongResult2);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/EditAlbum.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
