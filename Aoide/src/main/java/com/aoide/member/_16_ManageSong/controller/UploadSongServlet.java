package com.aoide.member._16_ManageSong.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.UploadSongService;

@WebServlet("/UploadSongServlet")
public class UploadSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SongVO songVO = new SongVO();
		UploadSongService uss = new UploadSongService();
		
		request.setCharacterEncoding("UTF-8");
		String songFile = request.getParameter("songFile");
		String coverFile = request.getParameter("coverFile");
		String name = request.getParameter("name");
		String songType = request.getParameter("songType");
		String songLanguage = request.getParameter("songLanguage");
		String introductionFile = request.getParameter("introductionFile");
		String lyricsFile = request.getParameter("lyricsFile");
		Date updateDate = new Date(System.currentTimeMillis());
		
		songVO.setSongFile(songFile);
		songVO.setCoverFile(coverFile);
		songVO.setName(name);
		songVO.setSongType(songType);
		songVO.setSongLanguage(songLanguage);
		songVO.setMemberId(1);
		songVO.setIntroductionFile(introductionFile);
		songVO.setLyricsFile(lyricsFile);
		songVO.setUpdateDate(updateDate);
		
		uss.insertUploadSong(songVO);
		
		request.getSession().setAttribute("songVO", songVO);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_16_ManageSong.view/UploadSongSuccess.jsp");
	}

}
