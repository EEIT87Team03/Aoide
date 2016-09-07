package com.aoide.manager._24_EditBullet.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.bullet.BulletDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.BulletVO;
import com.aoide.global.dataBaseManipulationObjects.bullet.JdbcBulletDAO;

@WebServlet("/EditBullet")
public class EditBullet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
		// getParameter必是String類型
		//取系統時間
		//Date date = new Date(System.currentTimeMillis());
		//String date = request.getParameter("date");
		String contentFile = request.getParameter("contentFile");
		String title = request.getParameter("title");
		
		BulletDAO dao = new JdbcBulletDAO();
		BulletVO bulletVO = new BulletVO();
		
		//bulletVO.setDate(date);
		bulletVO.setTitle(contentFile);
		bulletVO.setContentFile(title);
		dao.insert(bulletVO);
		
		request.getSession().setAttribute("bulletVO", bulletVO);
		String Path = request.getContextPath();
		response.sendRedirect(Path + "/_24_EditBullet.view/UploadBulletDisplay.jsp");
		
	}

}