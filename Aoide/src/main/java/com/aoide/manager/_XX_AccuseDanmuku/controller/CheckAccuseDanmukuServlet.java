package com.aoide.manager._XX_AccuseDanmuku.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.manager._XX_AccuseDanmuku.model.CheckAccuseDanmukuService;


@WebServlet("/CheckAccuseDanmukuServlet")
public class CheckAccuseDanmukuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AccusementDanmukuVO> accusementDanmukuVOList = new CheckAccuseDanmukuService().getAllAccusement();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
