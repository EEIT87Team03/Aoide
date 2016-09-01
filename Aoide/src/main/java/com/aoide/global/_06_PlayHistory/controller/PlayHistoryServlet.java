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
		
		List<ClickhistoryVO> clickhistorys = new PlayHistoryService().getAllClickhistory();
		
		for(ClickhistoryVO clickhistory : clickhistorys){
			
			System.out.println(clickhistory.getClickhistoryId());
			System.out.println(clickhistory.getSongId());
			System.out.println(clickhistory.getDate());	
			
			
		}

		System.out.println("123");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
