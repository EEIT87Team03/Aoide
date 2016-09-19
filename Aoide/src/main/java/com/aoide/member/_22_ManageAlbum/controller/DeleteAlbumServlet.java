package com.aoide.member._22_ManageAlbum.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.song.SongVO;
import com.aoide.member._16_ManageSong.model.ListSongService;
import com.aoide.member._22_ManageAlbum.model.ListAlbumService;

@WebServlet("/DeleteAlbumServlet")
public class DeleteAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListAlbumService service = new ListAlbumService();
		ListSongService lss = new ListSongService();
		
		request.setCharacterEncoding("UTF-8");
		Integer id = new Integer(request.getParameter("id"));
		System.out.println("delete id：" + id);
		
		List<SongVO> mySongResult = new ListSongService().getMySong();
		List<SongVO> songS = new ArrayList();
		for(SongVO song:mySongResult){
			if(song.getAlbumId() == id){    //int
				song.setAlbumId(1);
				lss.updateSong(song);
				songS.add(song);
			}
		}
		
		service.deleteAlbum(id);
		request.getSession().setAttribute("mySongList", songS);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_22_ManageAlbum.view/DeleteAlbumSuccess.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
