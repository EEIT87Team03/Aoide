package com.aoide.global._08_Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AjaxLogoutServlet")
public class AjaxLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ( session.getAttribute( "member" ) != null ){
			session.removeAttribute( "member" );
		}
		
		System.out.println("member: " + session.getAttribute("member"));
		
		// generate respond
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().write("logoutSuccess");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
