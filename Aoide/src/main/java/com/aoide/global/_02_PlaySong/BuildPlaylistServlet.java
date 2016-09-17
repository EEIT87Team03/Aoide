package com.aoide.global._02_PlaySong;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.websocket.Playlist;
import com.aoide.global.websocket.track.TrackService;
import com.aoide.global.websocket.track.TrackVO;

@WebServlet("/BuildPlaylist")
public class BuildPlaylistServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
    public BuildPlaylistServlet() 
    {
        super();
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		ServletContext context = getServletContext();
		Playlist playlist = ( Playlist ) context.getAttribute( Playlist.class.getName() );
		TrackService ts = new TrackService();
		//int id = Integer.parseInt( request.getParameter( "songId" ) );
		
		int id = 1; //test data
		
		TrackVO vo = ts.getTrackBean( id );
		if ( canPlay( vo ) )
		{
			playlist.add( vo );
			response.getWriter().write( "Add to playlist successfully" );
		}
		else
		{
			response.getWriter().write( "Cooldown duration" );
		}
			
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{
		doGet( request, response );
	}

	private boolean canPlay( TrackVO vo )
	{	
		//System.out.println( System.currentTimeMillis() );
		//System.out.println( vo.getLastclickDate().getTime() );
		return true;
	}
}
