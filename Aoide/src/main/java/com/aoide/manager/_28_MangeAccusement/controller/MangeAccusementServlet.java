package com.aoide.manager._28_MangeAccusement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.manager._28_MangeAccusement.model.MangeAccusementService;


@WebServlet("/MangeAccusementServlet")
public class MangeAccusementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AccusementDanmukuVO> accusementDanmukuVOList = new MangeAccusementService().getAllAccusement();
		
		request.getSession().setAttribute("accusementDanmukuVOList", accusementDanmukuVOList);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath+"/_28_MangeAccusement.view/ShowAccusementPage.jsp");
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
