package com.aoide.global._06_PlayHistory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global._06_PlayHistory.model.PlayHistoryService;
import com.aoide.global.dataBaseManipulationObjects.clickhistory.ClickhistoryVO;


@WebServlet("/PlayHistoryServlet")
public class PlayHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ClickhistoryVO> clickhistorysList = new PlayHistoryService().getAllClickhistory();
		
		ClickhistoryVO new_clickhistoryVO = new ClickhistoryVO();
		new_clickhistoryVO.setDate(java.sql.Date.valueOf("2019-12-25"));
		new_clickhistoryVO.setSongId(2);
		
		new PlayHistoryService().insetNewClickHistory(new_clickhistoryVO);
		
		
		for(ClickhistoryVO clickhistory : clickhistorysList){
			
			System.out.println(clickhistory.getClickhistoryId());
			System.out.println(clickhistory.getSongId());
			System.out.println(clickhistory.getDate());	
			
			
			
			
		}

		System.out.println("123");
		
		request.getSession().setAttribute("clickhistorysList", clickhistorysList);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_06_PlayHistory.view/showPlayHistory.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
