package com.aoide.global._08_Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


@WebServlet("/Login")
public class LoginAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginAccountServlet() {
        super();
        
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) 
												throws ServletException, IOException 
	{
		
		doPost( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException 
	{
		String account = request.getParameter( "account" );
		String password = request.getParameter( "password" );
		
		MemberService ms = new MemberService();
		MemberVO memberBean = ms.getMemberBean( account );
		if ( ( memberBean != null ) && password.equals( memberBean.getPassword() ) )
		{
			request.getSession().setAttribute( "member", memberBean );
			response.sendRedirect(
					request.getContextPath() + "/index.jsp" );
		}
		else
		{
			response.sendRedirect(
					request.getContextPath() + "/_08_login.view/login.html" );
		}
	}

}
