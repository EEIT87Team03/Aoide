package com.aoide.global._06_PlayHistory.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._06_PlayHistory.model.PlayHistoryService;
import com.aoide.global.dataBaseManipulationObjects.clickHistory.ClickHistoryVO;


@WebServlet("/PlayHistoryServlet")
public class PlayHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		//創建新的clickhistoryVO
//		ClickhistoryVO new_clickhistoryVO = new ClickhistoryVO();
//		new_clickhistoryVO.setDate(java.sql.Date.valueOf("2019-12-25"));
//		new_clickhistoryVO.setSongId(2);
//		//將新的clickhistoryVO物件放入資料庫
//		new PlayHistoryService().insetNewClickHistory(new_clickhistoryVO);
		
		
		
		//呼叫PlayHistoryService().getAllClickhistory()將從資料庫獲取全部的ClickhistoryVO物件
		List<ClickHistoryVO> clickhistorysList = new PlayHistoryService().getAllClickhistory();
		
		//用上面方法獲取的ClickhistoryVO List 並用迴圈遍歷擷取SongId
		//以SongId來呼叫PlayHistoryService().getSongNameBySongId(clickhistorys.getSongId())以獲得歌曲名字
		List<String> songNameList = new ArrayList();
		for(ClickHistoryVO clickhistorys : clickhistorysList){
			
			String songName = new PlayHistoryService().getSongNameBySongId(clickhistorys.getSongId());
			songNameList.add(songName);
			
		}
		
		//將歌曲名的List物件加入Session物件
		request.getSession().setAttribute("songIdList", songNameList);
		
		
		//加入List進Session物件
		request.getSession().setAttribute("clickhistorysList", clickhistorysList);
		
		//呼叫JSP  showPlayHistory.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_06_PlayHistory.view/showPlayHistory.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
