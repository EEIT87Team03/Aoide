package com.aoide.global._09_CheckMemberLogin;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;


@WebFilter( urlPatterns = { "*.member" }, dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE } )
public class IdentityAuthenticationFilter implements Filter 
{
    private FilterConfig config;
    
    public IdentityAuthenticationFilter() 
    {
        
    }

	public void destroy() 
	{
		
	}

	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) 
															throws IOException, ServletException 
	{
		HttpServletRequest req = ( HttpServletRequest ) request;
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute( "member" );
		if ( member == null )
		{
			( ( HttpServletResponse ) response ).sendRedirect( req.getContextPath() + "/home.jsp" );
		}
		else if( member.getBanState() ) // if the member is baned
		{
			( ( HttpServletResponse ) response ).sendRedirect( req.getContextPath() + "/views/member/_17_EditInfo.view/banPage.jsp" );
		}
		else
		{
			chain.doFilter( request, response );
		}
	}

	public void init( FilterConfig fConfig ) throws ServletException
	{
		this.config = fConfig;
	}

}
