package com.aoide.global._02_PlaySong;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.Playlist;
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
		int id = Integer.parseInt( request.getParameter( "songId" ) );
		
//		TrackVO vo1 = ts.getTrackBean( 1 );
//		TrackVO vo2 = ts.getTrackBean( 2 );
//		TrackVO vo3 = ts.getTrackBean( 3 );
//		playlist.add( vo1 );
//		playlist.add( vo2 );
//		playlist.add( vo3 );
		//response.sendRedirect( request.getContextPath() + "/play.html" );
		//response.sendRedirect( request.getContextPath() + "/index.jsp" );
		
		
		TrackVO vo = ts.getTrackBean( id );
		if ( canPlay( vo ) && updateSuccess( vo, ts ) )
		{
			playlist.add( vo );
			response.getWriter().write( "Add track to playlist successfully" );
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
		int cooldown = 0 * 60 * 1000;
		long current = System.currentTimeMillis();
		long lastClick = vo.getLastclickDate().getTime();
		
		if ( current - lastClick >= cooldown )
			return true;
		else
			return false;
	}
	
	private boolean updateSuccess( TrackVO vo, TrackService ts )
	{
		vo.setLastclickDate( new Timestamp( System.currentTimeMillis()) );
		if ( ts.updateTrackInfo( vo ) > 0 )
			return true;
		else
			return false;
	}
}
