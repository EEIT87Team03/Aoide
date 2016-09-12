package com.aoide.manager._24_EditBullet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.bullet.BulletDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.JdbcBulletDAO;

@WebServlet("/DeleteEditBullet")
public class DeleteEditBullet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		
	    //String DELETE = request.getParameter("deleteBullet");
		//String 轉 Int
		Integer DELETE = Integer.parseInt(request.getParameter("deleteBullet")); 
		
		BulletDAO dao = new JdbcBulletDAO();

		dao.delete(DELETE);
        
		
		System.out.println(request.getParameter("deleteBullet"));	
		System.out.println(DELETE);

	}
}