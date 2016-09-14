package com.aoide.member._15_ListFavorite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._15_ListFavorite.model.ListFavoriteService;

/**
 * Servlet implementation class ListFavoriteServlet
 */
@WebServlet("/ListFavoriteServlet.member")
public class ListFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListFavoriteServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = null;
		  session = request.getSession();
		
		  MemberVO memberVO = 
		   (MemberVO) session.getAttribute("member");
			
			List<FavoriteVO> favoriteAdd = new ListFavoriteService().getFavoritesById(memberVO.getMemberId());
			request.getSession().setAttribute("favorites", favoriteAdd);
			

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/views/member/_15_ListFavorite.view/FavoriteView.jsp");

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
