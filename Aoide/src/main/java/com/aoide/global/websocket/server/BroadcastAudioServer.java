package com.aoide.global.websocket.server;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint( value = "/play", configurator = ServletContextConfigurator.class )
public class BroadcastAudioServer 
{
	private Session wsSession;
    private HttpSession httpSession;
    private static ServletContext servletContext; 

	static
	{
		System.out.println( "Loading..." );
	}
	
	@OnOpen
    public void onOpen( Session session, EndpointConfig config ) 
	{
		this.wsSession = session;
        this.httpSession = ( HttpSession ) config.getUserProperties().get( HttpSession.class.getName() );
        servletContext = httpSession.getServletContext();                                   
	}
	
	@OnClose
    public void onClose( CloseReason reason ) 
	{
		System.out.println( "Close Session..." + reason.toString() );
	}

	@OnError
    public void onError( Throwable error ) 
	{
		System.out.println( "Error occured..." + error.getMessage() );
	}
}
