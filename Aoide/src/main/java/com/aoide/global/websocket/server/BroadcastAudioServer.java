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
        
        int id = 3; //test data
		TrackService ts = new TrackService();
		TrackVO vo = ts.getTrackBean( id );
		playlist.add( vo );
       
        broadcastObject( playlist.get( 0 ) );
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
	
	public void broadcastTrack( int initialTime, TrackVO track )
	{
		broadcastMessage( "[INIT_TIME] : " + initialTime );
		broadcastObject( track );
	}
	
	private void broadcastObject( Object vo ) 
	{
		for ( Session session : sessionList )
		{	 
			try
			{
				sendObject( session, vo );
			} 
			catch ( Exception ex) 
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
}
