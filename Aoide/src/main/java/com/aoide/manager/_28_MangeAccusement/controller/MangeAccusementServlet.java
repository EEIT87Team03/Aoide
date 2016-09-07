package com.aoide.manager._28_MangeAccusement.controller;

import java.io.IOException;
import java.util.ArrayList;
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
		
		//遍歷accusementDanmukuVOList獲取檢舉人ID與被檢舉人ID，用來將其轉換成帳號名稱
		List<String> accuseIdList = new ArrayList();
		List<String> accusedIdList = new ArrayList();
		
		
		for(AccusementDanmukuVO accusementDanmukuVO: accusementDanmukuVOList ){
			String accuseName = new MangeAccusementService().getAccuseName(accusementDanmukuVO.getAccuseId());
			accuseIdList.add(accuseName);
			String accusedName = new MangeAccusementService().getAccusedName(accusementDanmukuVO.getAccusedId());
			accusedIdList.add(accusedName);
		}
		request.getSession().setAttribute("accuseIdList", accuseIdList);
		request.getSession().setAttribute("accusedIdList", accusedIdList);
		
		
		 
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath+"/_28_MangeAccusement.view/ShowAccusementPage.jsp");
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
