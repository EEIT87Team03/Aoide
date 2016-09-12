package com.aoide.member._13_ShareSong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._03_DisplaySongInfo.model.DisplayDongService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._13_ShareSong.model.ShareService;


@WebServlet("/SelectOne.member")
public class SelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");


		
		int SongId = 6;
		
		
		
		SongVO new_songId = new ShareService().findByKey(SongId);
		request.getSession().setAttribute("songOnes", new_songId);
		
	
		
	    String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/_13_ShareSong.view/ShareSong.jsp");
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
		
		
		
		
	}

}
