package com.aoide.global.websocket.server;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatRoomServer
{
	static
	{
		System.out.println( "Loading..." );
	}
	
	private String username;
	private Session session;
	private static List< Session > sessionList = new ArrayList<>();
	private static List< String > userList = new ArrayList<>();
	
	private static final String LOGIN_HEADER = "[LOGIN]";
	private static final String LOGOUT_HEADER = "[LOGOUT]";
	private static final String JOIN_HEADER = "[JOIN]";
	private static final String LEFT_HEADER = "[LEFT]";
	private static final String INIT_HEADER = "[INIT]";
	
	@OnOpen
    public void onOpen( Session session ) 
	{
		System.out.println( "Open Session..." );
		this.session = session;
		sessionList.add( session );
		
		StringBuffer initUserList = new StringBuffer( INIT_HEADER + " " );
		for ( String user : userList )
		{
			initUserList.append( user ).append( "\n" );
		}
		sendMessage( initUserList.toString() );
	}

	@OnClose
    public void onClose( CloseReason reason ) 
	{
		sessionList.remove( session );
		userList.remove( username );
		broadcastMessage( LEFT_HEADER + " " + username );
		System.out.println( "Close Session..." + reason.toString() );
	}

	@OnError
    public void onError( Throwable error ) 
	{
		
	}

	@OnMessage
    public void handleMessage( String message ) 
	{
		if ( message.indexOf( LOGIN_HEADER ) == 0 )
		{
			username = message.substring( LOGIN_HEADER.length() + 1, message.length() );
			userList.add( username );
			broadcastMessage( JOIN_HEADER + " " + username );
		}
		else if ( message.indexOf( LOGOUT_HEADER ) == 0 )
		{
			sessionList.remove( session );
			userList.remove( username );
			broadcastMessage( LEFT_HEADER + " " + username );
		}
		else
		{
			broadcastMessage( message );
		}
	}
	
	private void sendMessage( String message )
	{
		try 
		{
			session.getBasicRemote().sendText(  message );
		} 
		catch ( Exception ex )
		{
			System.out.println("Error updating a client : " + ex.getMessage() );
		}
	}
	
	private void broadcastMessage( String message ) 
	{
		for ( Session nextSession : sessionList )
		{	 
			try
			{
				nextSession.getBasicRemote().sendText(  message );
			} 
			catch ( Exception ex) 
			{
		        System.out.println("Error updating a client : " + ex.getMessage() );
		    }
		}
	}
}
