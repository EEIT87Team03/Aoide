package com.aoide.member._17_EditInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Base64;

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
		Base64.Encoder encoder = Base64.getEncoder();
		MemberService ms = new MemberService();
		MemberVO bean = ms.getMemberBean( "whiteBirdBeauty" );
		request.getSession().setAttribute( "member", bean );
		//test data		
		
		HttpSession session =  request.getSession();
		MemberVO memberBean = ( MemberVO ) session.getAttribute( "member" );
		if ( memberBean != null )
		{
			response.sendRedirect(
					request.getContextPath() + "/memberInfo.jsp" );
		}
		else
		{
			response.sendRedirect(
					request.getContextPath() + "/_08_login.view/login.html" );
		}
	}

}
