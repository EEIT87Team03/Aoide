package com.aoide.member._13_ShareSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._13_ShareSong.model.ShareService;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareServlet.member")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShareServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		SongVO songVO = new SongVO();
		

		 HttpSession session = request.getSession();
		 Integer song_Id = (Integer) session.getAttribute("song1");
	
//		List<SongVO> song = new ShareService().getAllId(song_Id);
//		request.getSession().setAttribute("getSong", song);
		
		List<SongVO> song = new ShareService().getSong(song_Id);
		request.getSession().setAttribute("getSong", song);
		
		SongVO new_song = new ShareService().findByKey(song_Id);
		request.getSession().setAttribute("songOnes", new_song);

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_13_ShareSong.view/ShareSong.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
