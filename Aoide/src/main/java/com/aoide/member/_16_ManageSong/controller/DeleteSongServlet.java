package com.aoide.member._16_ManageSong.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.member._16_ManageSong.model.ListSongService;

@WebServlet("/DeleteSongServlet")
public class DeleteSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListSongService service = new ListSongService();
		
		request.setCharacterEncoding("UTF-8");
		Integer id = new Integer(request.getParameter("id"));
		System.out.println("delete id：" + id);
		
		service.deleteSong(id);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_16_ManageSong.view/DeleteSongSuccess.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
