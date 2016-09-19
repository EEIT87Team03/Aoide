package com.aoide.global.websocket.filter;

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


@WebFilter( urlPatterns = { "/play" }, dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE } )
public class WebSocketRequestFilter implements Filter
{
	private FilterConfig config;
    public WebSocketRequestFilter() 
    {
       
    }

	public void destroy() 
	{
		
	}

	
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException 
	{
		( ( HttpServletRequest ) request ).getSession();//ensure the HttpSession instance exists before websocket connection was created
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		this.config = fConfig;
	}

}
