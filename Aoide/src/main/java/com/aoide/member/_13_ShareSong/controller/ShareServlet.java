package com.aoide.member._13_ShareSong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		int songId = 1;


		List<SongVO> song = new ShareService().getAllId(songId);
		request.getSession().setAttribute("getSong", song);

		int song_Id = 1;
		SongVO new_song = new ShareService().findByKey(song_Id);
		request.getSession().setAttribute("songOnes", new_song);

		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_13_ShareSong.view/ShareSong.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
