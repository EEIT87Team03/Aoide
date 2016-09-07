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
import com.aoide.member._12_UpdateFavorite.model.ShowFavoriteService;


@WebServlet("/ShowFavoriteServlet.member")
public class ShowFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//從Session物件中獲得已登入會員的資料
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		
		//使用UpdateFavoriteService().getFavoriteById(member.getMemberId())獲得特定ID的FavoriteVO物件串
		List<FavoriteVO> favoriteVOList = new ShowFavoriteService().getFavoriteById(member.getMemberId());
		
		//以SongId來呼叫ShowFavoriteService().getSongNameBySongId(clickhistorys.getSongId())以獲得歌曲名字
		List<String> songNameList = new ArrayList();
		for(FavoriteVO favoriteVO : favoriteVOList){
			
			String songName = new ShowFavoriteService().getSongNameBySongId(favoriteVO.getSongId());
			songNameList.add(songName);
			
		}
		
		//將歌曲名的List物件加入Session物件
		request.getSession().setAttribute("songIdList", songNameList);
		
		//將FavoriteVO物件串放入Session物件中
		request.getSession().setAttribute("favoriteVOList", favoriteVOList);
		
		//導向顯示頁面
		String context = request.getContextPath();
		response.sendRedirect(context + "/_12_UpdateFavorite.view/ShowFavoritePage.jsp");
		
		
		
		
		
		
		
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		Integer songId = null;
		Integer memberId = null;
		String songIdStr = null;
		HttpSession session = null;
		MemberO member = null;
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
		 * 
		 * 
		 * 
		 */
		
		
		
		
	}

}
