package com.aoide.global.websocket.server;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator 
{
	@Override
    public void modifyHandshake( ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response )
    {
        HttpSession httpSession = ( HttpSession ) request.getHttpSession();
        if ( httpSession != null )
        	config.getUserProperties().put( HttpSession.class.getName(), httpSession );
        else
        	System.out.println( "HttpSession does not exist, configure failed" );
    }
}
