package com.aoide.global._08_Login;

import java.io.IOException;
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


@WebFilter( urlPatterns = { "/memberService.view/*" } )
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
		if ( session.getAttribute( "member" ) == null )
		{
			( ( HttpServletResponse ) response ).sendRedirect( req.getContextPath() + "/login.html" );
		}
		else
			chain.doFilter( request, response );
	}

	public void init( FilterConfig fConfig ) throws ServletException
	{
		this.config = fConfig;
	}

}
