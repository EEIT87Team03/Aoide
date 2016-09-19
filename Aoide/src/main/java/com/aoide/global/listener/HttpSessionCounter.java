package com.aoide.global.listener;

import javax.servlet.annotation.WebListener; 
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AoideHttpSessionListener
 *
 */
@WebListener
public class HttpSessionCounter implements HttpSessionListener 
{
	private static int activeSessions;
	
    public HttpSessionCounter()
    {
    }

	public static int getActiveSessionsCount()
	{
		return activeSessions;
	}
	
    public void sessionCreated( HttpSessionEvent event )  
    { 
    	activeSessions++;
    }

    public void sessionDestroyed( HttpSessionEvent event )  
    { 
    	activeSessions--;
    }
	
}
