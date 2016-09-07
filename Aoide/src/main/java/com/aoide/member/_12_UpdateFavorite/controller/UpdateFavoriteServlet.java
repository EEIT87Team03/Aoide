package com.aoide.member._12_UpdateFavorite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._12_UpdateFavorite.model.ShowFavoriteService;
import com.aoide.member._12_UpdateFavorite.model.UpdateFavoriteService;


@WebServlet("/UpdateFavoriteServlet.member")
public class UpdateFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//從Session物件中獲得已登入會員的資料
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		Integer memberId = member.getMemberId();
		
		//從外部來的值，表示今天要對哪一首歌進行操作，假設對id=4的歌曲按下了"收藏"
		Integer songId = 4 ; 
		
		//使用UpdateFavoriteService().getFavoriteById(member.getMemberId())獲得特定ID的FavoriteVO物件串
		List<FavoriteVO> favoriteVOList = new ShowFavoriteService().getFavoriteById(memberId);
		
		for(FavoriteVO favoriteVO : favoriteVOList){
			
			if(favoriteVO.getSongId() == songId){//如果自己的Favorite名單裡面已經有了該首歌的ID
				
				System.out.println("該玩家以收藏該首歌，改為刪除此歌的收藏紀錄");
				new UpdateFavoriteService().delectFavorite(memberId,songId);
				
				//呼叫ShowFavoriteServlet.member進行顯示
				response.sendRedirect("/Aoide//ShowFavoriteServlet.member");
				return;
			};
			
		};
		
		System.out.println("資料庫裡該玩家沒有收藏該首歌，將新增一筆資料入資料庫");
		new UpdateFavoriteService().insertFavorite(memberId,songId);
		
		//呼叫ShowFavoriteServlet.member進行顯示
		response.sendRedirect("/Aoide/ShowFavoriteServlet.member");
		return;
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
