package com.aoide.manager._28_ManageAccusement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.HibernateAccusementDanmukuVO;
import com.aoide.manager._28_ManageAccusement.model.ManageAccusementService;


@WebServlet("/ListAccusementServlet")
public class ListAccusementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get all accusements
		List<HibernateAccusementDanmukuVO> accusements = new ManageAccusementService().getAllAccusement();
		// put accusements in session
		request.getSession().setAttribute("accusements", accusements);
		// go accusementList.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/manager/_28_ManageAccusement.view/accusementList.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
