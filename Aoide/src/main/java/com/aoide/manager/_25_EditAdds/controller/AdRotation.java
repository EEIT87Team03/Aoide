package com.aoide.manager._25_EditAdds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.bullet.BulletDAO;
import com.aoide.global.dataBaseManipulationObjects.bullet.BulletVO;
import com.aoide.global.dataBaseManipulationObjects.bullet.JdbcBulletDAO;

@WebServlet("/AdRotation")
public class AdRotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// go to checkUploadResult.jsp
		System.out.println("In DisplayResultServlet");
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath
				+ "/_25_EditAd.view/UploadEditAdDisplay.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}