package com.aoide.global._05_DisplayDanmuku.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayDanmmuServlet.member")
public class DisplayDanmmuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		//response.sendRedirect(contextPath + "/danmmuRoom.jsp");
		response.sendRedirect(contextPath + "/views/global/_05_DisplayDanmuku/danmmuRoomTemplate.jsp");
		//response.sendRedirect(contextPath + "/views/global/_05_DisplayDanmuku/index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
