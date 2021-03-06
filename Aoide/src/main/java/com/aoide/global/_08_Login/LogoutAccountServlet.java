package com.aoide.global._08_Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class LogoutAccountServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
    public LogoutAccountServlet()
    {
        super();
        
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) 
													throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if ( session.getAttribute( "member" ) != null )
		{
			session.removeAttribute( "member" );
		}
		response.sendRedirect( request.getContextPath() + "/index.jsp" );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
