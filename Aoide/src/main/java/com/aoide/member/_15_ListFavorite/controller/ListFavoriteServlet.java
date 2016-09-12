package com.aoide.member._15_ListFavorite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.favorite.FavoriteVO;
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
		
		
		
     	   int	memberId = 2;
		   int  songId =8;
			
			FavoriteVO favoritelist = new ListFavoriteService().findByPrimaryKey(memberId, songId);
			request.getSession().setAttribute("favorite", favoritelist);
			

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/_15_ListFavorite.view/FavoriteView.jsp");

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
