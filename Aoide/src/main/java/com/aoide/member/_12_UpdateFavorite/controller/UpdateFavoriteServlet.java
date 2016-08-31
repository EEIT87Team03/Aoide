package com.aoide.member._12_UpdateFavorite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._12_UpdateFavorite.model.UpdateFavoriteService;


@WebServlet("/UpdateFavoriteServlet.member")
public class UpdateFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer songId = null;
		Integer memberId = null;
		String songIdStr = null;
		HttpSession session = null;
		MemberVO member = null;
		UpdateFavoriteService service = null;
		
		// get memberId and songId
		request.setCharacterEncoding("UTF-8");
		songIdStr = request.getParameter("SongId").trim();
		if((songIdStr != null) && (songIdStr.length() != 0)){
			songId = Integer.parseInt(songIdStr);
		}
		
		session = request.getSession();
		session.getAttribute("loginMember");
		if(member != null){
			memberId = member.getMemberId();
		}
		
		// call service to update Favorite
		service = new UpdateFavoriteService();
		service.updateFavoriteList(memberId, songId);
		service.updateSongFavoriteCounts(songId);
		
		// go xxx.jsp
		
	}

}
