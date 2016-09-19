package com.aoide.global.websocket.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.aoide.global.websocket.Playlist;
import com.aoide.global.websocket.codec.TrackVOEncoder;
import com.aoide.global.websocket.track.TrackService;
import com.aoide.global.websocket.track.TrackVO;

@ServerEndpoint( value = "/play", configurator = HttpSessionConfigurator.class, encoders = { TrackVOEncoder.class} )
public class BroadcastAudioServer 
{
	private Session wsSession;
    private HttpSession httpSession;
    private static ServletContext servletContext; 
    private static Playlist playlist;
    private static List< Session > sessionList = new ArrayList<>();
	
	@OnOpen
    public void onOpen( Session session, EndpointConfig config ) 
	{   
		this.wsSession = session;
		sessionList.add( session );
		
        this.httpSession = ( HttpSession ) config.getUserProperties().get( HttpSession.class.getName() );
        servletContext = httpSession.getServletContext();
        playlist = ( Playlist ) servletContext.getAttribute( Playlist.class.getName() );
        
		
       
        sendTrack( playlist.getCurrentPlayingTrackLength(), playlist.get( 0 ) );
	}
	
	@OnMessage
    public void handleMessage( String message ) 
	{
		
		if ( message.equals( "[NEXT]" ) );
		{
			sendTrack( playlist.getCurrentPlayingTrackLength(), playlist.get( 0 ) );
		}
	}
	
	@OnClose
    public void onClose( CloseReason reason ) 
	{
		sessionList.remove( wsSession );
		System.out.println( "Close Session..." + reason.toString() );
	}

	@OnError
    public void onError( Throwable error ) 
    {
		System.out.println( "Error occured..." + error.getMessage() );
	}
	
	public void sendTrack( int initialTime, TrackVO track )
	{
		try 
		{
			sendMessage( "[INIT_TIME] " + initialTime );
			sendObject( track );
		} 
		catch ( Exception e ) 
		{
			System.out.println("Error updating a client : " + e.getMessage() );
			e.printStackTrace();
		}
		
	}
	
	private void broadcastObject( Object vo ) 
	{
		for ( Session session : sessionList )
		{	 
			try
			{
				sendObject( session, vo );
			} 
			catch ( Exception ex ) 
			{
		        System.out.println("Error updating a client : " + ex.getMessage() );
		    }
		}
	}
	
	private void broadcastMessage( String message ) 
	{
		for ( Session session : sessionList )
		{	 
			try
			{
				sendMessage( session, message );
			} 
			catch ( Exception ex) 
			{
		        System.out.println("Error updating a client : " + ex.getMessage() );
		    }
		}
	}
	
	private void sendMessage( Session session, String message ) throws IOException
	{
		session.getBasicRemote().sendText(  message );
	}
	
	private void sendObject( Session session, Object vo ) throws IOException, EncodeException
	{
		session.getBasicRemote().sendObject( vo );
	}
	
	private void sendMessage(  String message ) throws IOException
	{
		wsSession.getBasicRemote().sendText(  message );
	}
	
	private void sendObject(  Object vo ) throws IOException, EncodeException
	{
		wsSession.getBasicRemote().sendObject( vo );
	}
}
