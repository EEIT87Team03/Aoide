package com.aoide.global._08_Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public CreateAccountServlet() 
    {
        super();
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) 
													throws ServletException, IOException 
	{
		
		
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) 
													throws ServletException, IOException 
	{
		String account = request.getParameter( "account" );
		String password = request.getParameter( "password" );
	}

}
