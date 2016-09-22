package com.aoide.member._22_ManageAlbum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.album.AlbumVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.member._22_ManageAlbum.model.ListAlbumService;

@WebServlet("/ListAlbumServlet.member")
public class ListAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
//		Integer memberId = member.getMemberId();
		Integer memberId = 3;
		
		List<AlbumVO> myAlbumResult = new ListAlbumService().getMyAlbum(memberId);
		for (AlbumVO myAlbum : myAlbumResult) {
			System.out.println("我的專輯：" + myAlbum.getName());
		}
		
		request.getSession().setAttribute("myAlbumList", myAlbumResult);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/ListAlbum.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
