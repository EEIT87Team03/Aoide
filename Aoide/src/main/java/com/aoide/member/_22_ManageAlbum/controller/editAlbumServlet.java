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

@WebServlet("/editAlbumServlet")
public class editAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		List<AlbumVO> albumVO;
		HttpSession session = null;
		
		// get the album id
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id").trim();
		if(idStr != null && idStr.length() != 0){
			id = Integer.parseInt(idStr);
		}
		
		// get the albumVO by id from session
		session = request.getSession();
		albumVO = (List<AlbumVO>) session.getAttribute("myAlbumList"); // from ListAlbumServlet
		
		// put the albumVO in session
		for(AlbumVO aAlbum:albumVO){
			if(aAlbum.getAlbumId() == id){
				session.setAttribute("aAlbum", aAlbum);
			}
		}
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_22_ManageAlbum.view/editAlbum.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
