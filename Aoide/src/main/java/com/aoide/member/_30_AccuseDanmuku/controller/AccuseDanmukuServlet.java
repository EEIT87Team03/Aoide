package com.aoide.member._30_AccuseDanmuku.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AccuseDanmukuServlet")
public class AccuseDanmukuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("現在被檢舉的彈幕會員ID:"+request.getParameter("id"));
		System.out.println("現在被檢舉的彈幕內容:"+request.getParameter("text"));
		
		String contextPath = request.getContextPath();
		
		request.getSession().setAttribute("accused_id", request.getParameter("id"));
		request.getSession().setAttribute("accused_text", request.getParameter("text"));
		
		//response.sendRedirect(contextPath + "/_30_AccuseDanmuku.view/AccuseDanmmuPage.jsp");
		response.sendRedirect(contextPath + "/views/member/_30_AccuseDanmuku.view/AccuseDanmmuPageTemplate.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
