package com.aoide.global.websocket.server;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class ServletContextConfigurator extends ServerEndpointConfig.Configurator 
{
	@Override
    public void modifyHandshake( ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response )
    {
		System.out.println( "HandshakeRequest : " + request );
        HttpSession httpSession = ( HttpSession ) request.getHttpSession();
        System.out.println( "HttpSession : " + httpSession );
        config.getUserProperties().put( HttpSession.class.getName(), httpSession );
    }
}
