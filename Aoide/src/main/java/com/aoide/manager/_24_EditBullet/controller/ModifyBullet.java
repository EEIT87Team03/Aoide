package com.aoide.manager._24_EditBullet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.bullet.BulletVO;


@WebServlet("/ModifyBullet")
public class ModifyBullet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = null;
		List<BulletVO> bulletS;
		HttpSession session = null;
		
		// get the song id
		request.setCharacterEncoding("UTF-8");
		String idStr = request.getParameter("id").trim();
		System.out.println(idStr);
		if(idStr != null && idStr.length() != 0){
			id = Integer.parseInt(idStr);
		}
		
		// get the songVO by id from session
		session = request.getSession();
		bulletS = (List<BulletVO>) session.getAttribute("BulletList"); // from ListSongServlet
		// put the songVO in session
		for(BulletVO bulletVO:bulletS){
			System.out.println("bulletVO.getBulletId(): " + bulletVO.getBulletId());
			if(bulletVO.getBulletId() == id){
				System.out.println("-------id: " + id);
				session.setAttribute("bulletVO", bulletVO);
			}
		}
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/manager/_24_EditBullet.view/ModifyBullet.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}