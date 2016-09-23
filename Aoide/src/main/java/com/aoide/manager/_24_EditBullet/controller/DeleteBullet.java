package com.aoide.manager._24_EditBullet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.bullet.BulletDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.JdbcBulletDAO;
import com.aoide.member._16_ManageSong.model.ListSongService;

@WebServlet("/DeleteBullet")
public class DeleteBullet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BulletDAO dao = new JdbcBulletDAO();
		
		request.setCharacterEncoding("UTF-8");
		Integer DELETE = new Integer(request.getParameter("id"));
		System.out.println("delete id：" + DELETE);
		
		dao.delete(DELETE);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/manager/_24_EditBullet.view/DeleteBulletDisplay.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
