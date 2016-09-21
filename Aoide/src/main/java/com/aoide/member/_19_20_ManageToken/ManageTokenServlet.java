package com.aoide.member._19_20_ManageToken;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ManageTokenServlet")
public class ManageTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_19_20_ManageToken.view/ManageToken.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
