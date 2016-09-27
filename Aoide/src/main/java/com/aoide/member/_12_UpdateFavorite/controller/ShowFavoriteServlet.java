package com.aoide.member._12_UpdateFavorite.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global._06_PlayHistory.model.PlayHistoryService;
import com.aoide.global.dataBaseManipulationObjects.clickHistory.ClickHistoryVO;
import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._12_UpdateFavorite.model.ShowFavoriteService;
import com.aoide.member._12_UpdateFavorite.model.UpdateFavoriteService;


@WebServlet("/ShowFavoriteServlet.member")
public class ShowFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get member id 
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		
		// call service to get favorite songs
		List<SongVO> songs = new ShowFavoriteService().getFavoriteSongs( member.getMemberId() );
//		List<SongVO> songs = new ShowFavoriteService().getFavoriteSongs( 1 );
		
		
		// put songs in session
		request.getSession().setAttribute("songs", songs);
		
		// go to listFavorite.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_12_UpdateFavorite.view/ShowFavoritePage.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
}
