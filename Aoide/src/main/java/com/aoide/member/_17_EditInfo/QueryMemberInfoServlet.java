package com.aoide.member._17_EditInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.member.MemberService;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


@WebServlet("/QueryMember")
public class QueryMemberInfoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    
    public QueryMemberInfoServlet() 
    {
        
    }

	
	protected void doGet( HttpServletRequest request, HttpServletResponse response )
												throws ServletException, IOException 
	{
		
		doPost(request, response);
	}

	
	protected void doPost( HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException 
	{
		HttpSession session =  request.getSession();
		MemberVO memberBean = ( MemberVO ) session.getAttribute( "member" );
		if ( memberBean != null )
		{
			response.sendRedirect(
					request.getContextPath() + "/memberService.view/memberInfo.jsp" );
		}
		else
		{
			response.sendRedirect(
					request.getContextPath() + "/_08_login.view/login.html" );
		}
	}

}
