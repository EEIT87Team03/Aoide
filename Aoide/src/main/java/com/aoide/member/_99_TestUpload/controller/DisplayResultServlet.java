package com.aoide.member._99_TestUpload.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayResultServlet")
public class DisplayResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // go to checkUploadResult.jsp
		System.out.println("In DisplayResultServlet");
	    String contextPath = request.getContextPath();
	    response.sendRedirect(contextPath + "/views/member/_99_TestUpload.view/checkUploadResult.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
