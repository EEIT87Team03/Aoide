package com.aoide.member._22_ManageAlbum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.member._22_ManageAlbum.model.ListAlbumService;

@WebServlet("/deleteAlbumServlet")
public class deleteAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListAlbumService service = new ListAlbumService();
		
		request.setCharacterEncoding("UTF-8");
		Integer id = new Integer(request.getParameter("id"));
		System.out.println("id: " + id);
		
		service.deleteAlbum(id);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/deleteAlbumSuccess.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
