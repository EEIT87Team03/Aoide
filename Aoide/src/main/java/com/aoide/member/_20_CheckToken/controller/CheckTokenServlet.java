package com.aoide.member._20_CheckToken.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.tokenRecord.TokenRecordVO;
import com.aoide.member._20_CheckToken.model.CheckTokenService;

/**
 * Servlet implementation class CheckTokenServlet
 */
@WebServlet("/CheckTokenServlet")
public class CheckTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TokenRecordVO> tokenRecordList = new CheckTokenService().getAllTokenRecordByMemberId();
		
		request.getSession().setAttribute("tokenRecordList", tokenRecordList);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
