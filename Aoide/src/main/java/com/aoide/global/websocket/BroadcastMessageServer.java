package com.aoide.global.websocket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/danmu")
public class BroadcastMessageServer 
{
	static
	{
		System.out.println( "Loading..." );
	}
	
	private Session session;
	private static List< Session > sessionList = new ArrayList<>();
	
	
	@OnOpen
    public void onOpen( Session session ) 
	{
		System.out.println( "Open session..." );
		this.session = session;
		sessionList.add( session );
	}

	@OnClose
    public void onClose( CloseReason reason ) 
	{
		sessionList.remove( session );
		System.out.println( "Close session..." + reason.toString() );
	}

	@OnError
    public void onError( Throwable error ) 
	{
		sessionList.remove( session );
		System.out.println( "Error occured..." + error.getMessage() );
	}

	@OnMessage
    public void handleMessage( String message ) 
	{
		
		broadcastMessage( message );
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
