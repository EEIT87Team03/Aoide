package com.aoide.manager._24_EditBullet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.bullet.BulletVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.manager._24_EditBullet.model.BulletService;

@WebServlet("/EditBulletList.manager")
public class EditBulletList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("In ReplySuggestionsServlet doGet()");
		// get the suggestion list from service

		List<BulletVO> bulletList = new BulletService().getUnreplyBulletVO();
		// 包入BulletList
		request.getSession().setAttribute("BulletList", bulletList);

		// go suggestionList.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath
				+ "/views/manager/_24_EditBullet.view/BulletList.jsp");
	}// end doGet()

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("In ReplyBulletServlet doPost()");
	}
}